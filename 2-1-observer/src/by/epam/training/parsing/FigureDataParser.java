package by.epam.training.parsing;

import java.util.*;
import java.util.regex.Pattern;

public class FigureDataParser {

	final String SPACES = "\\s+";
	final String DELIMITER = ";";

	/*
	 * Parse string and creation of list<Integer> - objectParameters for Pyramid
	 * Provider of objectParameters is class FileDataValidation
	 */
	public List<Integer> parseValues(String validatedList) {

		return getValues(Normalize(validatedList));

	}

	/*
	 * change DELIMITER onto SPACE and delete double spaces out data is list of
	 * integers value
	 */
	private String[] Normalize(String s) {

		if (s.isEmpty()) {
			return new String[] {};
		}

		s = s.replace(DELIMITER, " ").replaceAll(SPACES, " ");

		// split values by spaces on single lexems
		Pattern pattern = Pattern.compile(SPACES);
		return pattern.split(s, 0);

	}

	/*
	 * change string[] lexems into List<Integer> values
	 */
	private List<Integer> getValues(String[] parsingStr) {

		ArrayList<Integer> parsedList = new ArrayList<Integer>();

		if (parsingStr.length == 0) {
			return parsedList;
		}

		for (int i = 0; i < parsingStr.length; i++) {

			try {
				parsedList.add(Integer.parseInt(parsingStr[i]));
			} catch (NumberFormatException e) {
			}

		}

		return parsedList;
	}

}
