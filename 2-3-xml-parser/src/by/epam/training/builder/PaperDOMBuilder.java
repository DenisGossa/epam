package by.epam.training.builder;

import by.epam.training.constant.PaperType;
import by.epam.training.entity.*;
import by.epam.training.exception.*;
import org.apache.logging.log4j.Level;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class PaperDOMBuilder extends AbstractPaperBuilder {
    private DocumentBuilder docBuilder;

    PaperDOMBuilder() throws ParserException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("config parser error: ", e);
        }
    }

    @Override
    public void buildSetPapers(String fileName) throws ParserException {
        Document doc = null;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();

            NodeList newspapersList = root.getElementsByTagName(PaperType.NEWSPAPER.getValue());
            NodeList journalsList = root.getElementsByTagName(PaperType.JOURNAL.getValue());
            NodeList bookletsList = root.getElementsByTagName(PaperType.BOOKLET.getValue());

            for (int i = 0; i < newspapersList.getLength(); i++) {
                Element newspaperElement = (Element) newspapersList.item(i);
                Paper paper = buildNewspaperOrJournal(newspaperElement, PaperType.NEWSPAPER);
                papers.add(paper);
            }

            for (int i = 0; i < journalsList.getLength(); i++) {
                Element journalElement = (Element) journalsList.item(i);
                Paper paper = buildNewspaperOrJournal(journalElement, PaperType.JOURNAL);
                papers.add(paper);
            }

            for (int i = 0; i < bookletsList.getLength(); i++) {
                Element bookletElement = (Element) bookletsList.item(i);
                Paper paper = buildBooklet(bookletElement);
                papers.add(paper);
            }
        } catch (FileNotFoundException e) {
            throw new ParserException("file not found", e);
        } catch (SAXException e) {
            throw new ParserException("sax exception", e);
        } catch (IOException e) {
            throw new ParserException("io exception", e);
        }
    }

    private Paper buildNewspaperOrJournal(Element newspaperElement, PaperType paperType) {
        Paper paper;
        if (paperType == PaperType.JOURNAL) {
            paper = new Journal();
        } else {
            paper = new Newspaper();
        }

        paper = buildSamePart(paper, newspaperElement);

        try {
            paper.setSubscriptionIndex(Integer.parseInt(newspaperElement.getAttribute(PaperType.SUBSCRIPTION_INDEX.getValue())));
            String glossValue = newspaperElement.getAttribute(PaperType.GLOSS.getValue());
            if (glossValue != null) {
                paper.setGloss(Boolean.parseBoolean(glossValue));
            }
        } catch (MethodNotSupportedException e) {
            LOGGER.log(Level.ERROR, e);
        }

        return paper;
    }

    private Paper buildBooklet(Element bookletElement) {
        Paper paper = new Newspaper();
        paper = buildSamePart(paper, bookletElement);

        try {
            String glossValue = bookletElement.getAttribute(PaperType.GLOSS.getValue());
            if (glossValue != null) {
                paper.setGloss(Boolean.parseBoolean(glossValue));
            }
        } catch (MethodNotSupportedException e) {
            LOGGER.log(Level.ERROR, e);
        }

        return paper;
    }

    private Paper buildSamePart(Paper paper, Element element) {
        NodeList mothlyList = element.getElementsByTagName(PaperType.MOTHLY.getValue());
        NodeList colorList = element.getElementsByTagName(PaperType.COLOR.getValue());
        NodeList volumeList = element.getElementsByTagName(PaperType.VOLUME.getValue());

        paper.setMothly(Boolean.parseBoolean(mothlyList.item(0).getTextContent()));
        paper.setColor(Boolean.parseBoolean(colorList.item(0).getTextContent()));
        paper.setVolume(Integer.parseInt(volumeList.item(0).getTextContent()));

        paper.setId(element.getAttribute(PaperType.PAPER_ID.getValue()));
        paper.setTittle(element.getAttribute(PaperType.TITTLE.getValue()));
        return paper;
    }
}
