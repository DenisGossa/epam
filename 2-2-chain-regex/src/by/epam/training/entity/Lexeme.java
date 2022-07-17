package by.epam.training.entity;

import java.util.ArrayList;

import java.util.List;
import java.util.regex.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.lexemtype.LexemType;
import by.epam.training.runner.Application;

public class Lexeme extends CompositeText {

	private static final Logger LOGGER = LogManager.getLogger(Lexeme.class);
	
	private final String WORD_REGEX = "([\\wÀ-ßà-ÿ-]+)([,:;!?]|((?<!\\.)\\.(?!\\.)|[!?]|\\.{3}))?";
	private final String PUNCTUATIONMARK = "[,:;]";

	public Lexeme(CompositeText compositeText) {
		super(compositeText);
	}

	@Override
	public void runnerParse(String parsingLexemToWord) {

		Pattern wordPattern = Pattern.compile(WORD_REGEX);
		Matcher wordMatcher = wordPattern.matcher(parsingLexemToWord);

		if (wordMatcher.find()) {

			ñompositTextList.add(new Word(wordMatcher.group(1)));
			LOGGER.log(Level.INFO,"Lexem added");
			
			String signValue = wordMatcher.group(2);
			if (signValue != null) {

				if (signValue.matches(PUNCTUATIONMARK)) {
					ñompositTextList.add(new Sign(signValue, LexemType.PUNCTUATIONMARK));
					LOGGER.log(Level.INFO,"PUNCTUATIONMARK added");
					
				} else {
					ñompositTextList.add(new Sign(signValue, LexemType.SENTENCELASTSIGN));
					LOGGER.log(Level.INFO,"SENTENCELASTSIGN added");
				}

			}

		}

	}

}