package by.epam.training.action;

import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.entity.CompositeText;
import by.epam.training.exception.NonCorrectParameterFormat;
import by.epam.training.lexemtype.LexemType;

public class SortParagraphByCountSentence {
	
	private static final Logger LOGGER = LogManager.getLogger(GetTextFromComposite.class);
	
	public static boolean sort(List<CompositeText> componentListToSort) throws NonCorrectParameterFormat {

		final int TEXT = 0;
		if (componentListToSort == null || componentListToSort.get(TEXT).getLexemType() != LexemType.TEXT) {
			throw new NonCorrectParameterFormat(
					"Have gotten noncoorect PARAMETER at function sortParagraphByCountSentence()");
		}
		componentListToSort.get(TEXT);
		
		List<CompositeText> sortedParagraphs = CompositeText.get—ompositTextList();
		sortedParagraphs.sort(Comparator.comparingInt(o -> CompositeText.get—ompositTextList().size()));
		
		LOGGER.log(Level.INFO, "Get SortParagraphByCountSentence");
		return true;

	}

}
