package by.epam.training.entity;

import java.util.regex.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.lexemtype.LexemType;

public class Paragraph extends CompositeText {
	
	private static final Logger LOGGER = LogManager.getLogger( Paragraph.class);
	private final String SENTENCE_REGEX = "([^.!?]+((?<!\\.)\\.(?!\\.)|[!?]|\\.{3}))";

	public Paragraph(CompositeText compositeText) {
		super(compositeText);
		lexemType = LexemType.PARAGRAPH;
	}

	@Override
	public void runnerParse(String parsingSentenceString) {
		ñompositTextList.add(this);
		LOGGER.log(Level.INFO,"PARAGRAPH added");

		Pattern regex = Pattern.compile(SENTENCE_REGEX);
		Matcher regexMatcher = regex.matcher(parsingSentenceString);

		while (regexMatcher.find()) {
			compositeText.runnerParse(regexMatcher.group());
		}

	}

	@Override
	public String toString() {
		 StringBuilder beginingParagraph = new StringBuilder();
		 beginingParagraph.append("\t\n");
		 
		 return beginingParagraph.toString();
		 
	}

	

}