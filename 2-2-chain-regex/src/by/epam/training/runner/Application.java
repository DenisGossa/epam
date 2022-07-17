package by.epam.training.runner;

import java.io.IOException;

//`import java.util.List;

import by.epam.training.action.GetTextFromComposite;
import by.epam.training.entity.*;
import by.epam.training.reader.DataReaderFromFile;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.LogManager;



public class Application {

	private static final Logger LOGGER = LogManager.getLogger( Application.class);

	
	public static void main(String[] args) {
		String fromFileText = new String();
				
		try {
		 fromFileText = DataReaderFromFile.loadData();
		}catch(IOException e) {
			LOGGER.log(Level.ERROR,"Error at loading from file");
		}
		
		
		
		System.out.println("Start parsing");
		CompositeText compositeText = new Text(new Paragraph(new Sentence(new Lexeme(null))));
		compositeText.runnerParse(fromFileText);
		
		
		List<CompositeText> list = 	CompositeText.get—ompositTextList();
		int size = list.size();
		System.out.println("List size = " + size);
		
		
		for(CompositeText tmp: list) {
		System.out.println("Lexem Type = " + tmp.getLexemType());
		}
		
		System.out.println("________________________________________________");
		
		String string = GetTextFromComposite.collectText(compositeText.get—ompositTextList());
		
		System.out.println(string);
	}
	

}
