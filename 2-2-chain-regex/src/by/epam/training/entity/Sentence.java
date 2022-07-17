package by.epam.training.entity;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.lexemtype.LexemType;

public class Sentence extends CompositeText {
	
	private static final Logger LOGGER = LogManager.getLogger(Sentence.class);
	private final String LEXEME_REGEX = "\\s";

	public Sentence(CompositeText compositeText) {
		super(compositeText);
		lexemType = LexemType.SENTENCE;
	}

	@Override
	public void runnerParse(String parsingStringToLexem) {

		ñompositTextList.add(this);
		LOGGER.log(Level.INFO,"SENTENCE added");
		
		String[] lexemArray = parsingStringToLexem.trim().split(LEXEME_REGEX);

		for (String lexemString : lexemArray) {

			compositeText.runnerParse(lexemString);

		}

	}

	@Override
	public String toString() {
		StringBuilder beginingSentence = new StringBuilder();
		beginingSentence.append("");

		return beginingSentence.toString();

	}

}