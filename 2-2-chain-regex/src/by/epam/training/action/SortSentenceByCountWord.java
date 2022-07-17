package by.epam.training.action;

import java.util.*;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.entity.CompositeText;
import by.epam.training.exception.NonCorrectParameterFormat;
import by.epam.training.lexemtype.LexemType;

public class SortSentenceByCountWord {
	
	private static final Logger LOGGER = LogManager.getLogger(SortSentenceByCountWord.class);
	
	public static boolean sort(List<CompositeText> componentListToSort) throws NonCorrectParameterFormat {

		final int FIRST = 0;

		if (componentListToSort.get(FIRST).getLexemType() == LexemType.TEXT) {

			componentListToSort.get(FIRST);
			List<CompositeText> paragraphList = CompositeText.get—ompositTextList();

			if (paragraphList != null) {
				for (CompositeText paragraph : paragraphList) {
					doSort(CompositeText.get—ompositTextList());

				}
			} else {
				throw new NonCorrectParameterFormat(
						"Have gotten non-coorect PARAMETER at function sortSentenseByCountWord");
			}

		} else {
			if (componentListToSort.get(FIRST).getLexemType() == LexemType.PARAGRAPH) {
				for (CompositeText paragraph : componentListToSort) {
					doSort(CompositeText.get—ompositTextList());

				}

			} else {
				if (componentListToSort.get(FIRST).getLexemType() == LexemType.SENTENCE) {

					sort(componentListToSort);

				} else {
					throw new NonCorrectParameterFormat(
							"Have gotten non-coorect PARAMETER at function sortSentenseByCountWord");

				}
			}

		}
		LOGGER.log(Level.INFO,"Get SortSentenceByCountWord");
		return true;

	}

	private static void doSort(List<CompositeText> sortedSentences) {

		sortedSentences.sort(Comparator.comparingInt(o -> CompositeText.get—ompositTextList().size()));

	}

}
