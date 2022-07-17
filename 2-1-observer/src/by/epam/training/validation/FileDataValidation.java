package by.epam.training.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileDataValidation {

	private List<String> validatedList = new ArrayList<>();

	/*
	 * Validate string and creation validated list<String> 
	 * Provider string for this class is class FileReader
	 */
	
	public List<String> validate(List<String> list) {

		if (list == null || list.isEmpty()) {
			return validatedList;
		}

		removeInvalidSymbol(list);

		if (!validatedList.isEmpty()) {

			checkDataFormat(validatedList);
		}

		return validatedList;
	}

	/*
	 * removing invalid symbols(chars and other) at list of string at incoming pyramid
	 * parameters, result input to resultList
	 */
	private void removeInvalidSymbol(List<String> list) {

		for (String str : list) {

			str = str.trim().replaceAll("\\s+", " ");

			if (Pattern.matches("[\\d+\\s+;-]+", str)) {

				validatedList.add(str);

			} else {
				// logger.log(level.WARN,"Not valid str: " + str);

			}

		}

	}

	/*
	 * checking for invalid count of coord: there are only must be 3 parameters for
	 * x y z . Then check count of the points: non less then 3 last value must be
	 * sinlge - this is the Heigth of Pyramid Non correct strings will be delete.
	 * result input to resultList
	 */
	private void checkDataFormat(List<String> list) {
		List<String> tmpList = new ArrayList<>();
		String regex = "-?\\d+;(\\s?-?\\d+\\s-?\\d+\\s-?\\d+\\s?;){4}";

		for (String str : list) {

			if (Pattern.matches(regex, str)) {

				tmpList.add(str);

			} else {
				// logger.log(log"NOT VALID: " + str);

			}

		}
		validatedList = tmpList;
	}

//  replace to ACTION PYRAMID
//	public boolean validateHeight(){return true;}
//	public boolean validatePointsValue(){return true;}

}
