package by.epam.training.action;

import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.training.entity.CompositeText;
import by.epam.training.exception.NonCorrectParameterFormat;
import by.epam.training.lexemtype.LexemType;

public class SortWordByLength {
	
	private static final Logger LOGGER = LogManager.getLogger(SortWordByLength.class);
	
	public boolean sort(List<CompositeText> componentListToSort) throws NonCorrectParameterFormat {

		final int FIRST = 0;

		if (componentListToSort.get(FIRST).getLexemType() == LexemType.TEXT) {

			componentListToSort.get(FIRST);
			
			List<CompositeText> paragraphList = CompositeText.get—ompositTextList();
			List<CompositeText> sentenseList, lexemList;
			
			if (paragraphList != null) {
				for (CompositeText paragraph : paragraphList) {

					sentenseList = CompositeText.get—ompositTextList();
					if (sentenseList != null) {
						for (CompositeText sentence : sentenseList) {
							lexemList = CompositeText.get—ompositTextList();
							if (lexemList != null) {
								for (CompositeText lexem : lexemList) {

									doSort(CompositeText.get—ompositTextList());
								}
							} else {
								throw new NonCorrectParameterFormat(
										"Have gotten non-coorect PARAMETER at function SortSentenceWordByLength.sort");
							}
						}
					} else {
						throw new NonCorrectParameterFormat(
								"Have gotten non-coorect PARAMETER at function SortSentenceWordByLength.sort");
					}

				}
			} else {
				throw new NonCorrectParameterFormat(
						"Have gotten non-coorect PARAMETER at function SortSentenceWordByLength.sort");
			}
		} else {
			if (componentListToSort.get(FIRST).getLexemType() == LexemType.PARAGRAPH) {

				List<CompositeText> sentenseList, lexemList;

				for (CompositeText paragraph : componentListToSort) {

					sentenseList = CompositeText.get—ompositTextList();
					if (sentenseList != null) {
						for (CompositeText sentence : sentenseList) {
							lexemList = CompositeText.get—ompositTextList();
							if (lexemList != null) {
								for (CompositeText lexem : lexemList) {

									doSort(CompositeText.get—ompositTextList());
								}
							} else {
								throw new NonCorrectParameterFormat(
										"Have gotten non-coorect PARAMETER at function SortSentenceWordByLength.sort");
							}
						}
					} else {
						throw new NonCorrectParameterFormat(
								"Have gotten non-coorect PARAMETER at function SortSentenceWordByLength.sort");
					}

				}

			} else {
				if (componentListToSort.get(FIRST).getLexemType() == LexemType.SENTENCE) {

					doSort(componentListToSort);

				} else {
					throw new NonCorrectParameterFormat(
							"Have gotten non-coorect PARAMETER at function sortSentenseByCountWord");

				}
			}

		}
		LOGGER.log(Level.INFO,"Get SortWordByLength");
		return true;

	}

	private void doSort(List<CompositeText> lexemList) {

		lexemList.sort(Comparator.comparingInt(o -> CompositeText.get—ompositTextList().size()));
	}

}
