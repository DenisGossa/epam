package typography.datavalidator;

import java.util.regex.Pattern;

import typography.Category;

public class CheckData {

	public static boolean isGoodPages(int num) {
		final int MAX_PAGES_COUNT = 5001;
		final int MIN_PAGES_COUNT = 0;
		if (MIN_PAGES_COUNT < num && num < MAX_PAGES_COUNT) {
			return true;
		}
		return false;
	};// for all//

	public static boolean isGoodTitle(String str) {
		final int MAX_TITLE_LENGTH = 201;
		final int MIN_TITLE_LENGTH = 0;

		if (str != null) {
			int len = str.length();
			if (MIN_TITLE_LENGTH < len && len < MAX_TITLE_LENGTH) {
				return true;
			}
		}
		return false;

	}// for all//

	public static boolean isGoodCategory(Category category) {
		return false;
	};// for all//

	public static boolean isGoodYear(int year) {
		final int MAX_YEAR = 2020;
		final int MIN_YEAR = 1850;
		if (MIN_YEAR < year && year < MAX_YEAR) {
			return true;
		}
		return false;

	};// for all//

	public static boolean isGoodNumber(int number) {
		final int MAX_NUMBER = 10000;
		final int MIN_NUMBER = 0;
		if (MIN_NUMBER < number && number < MAX_NUMBER) {
			return true;
		}

		return false;
	};// for Journal//for newspaper//

	public static boolean isGoodAuthor(String str) {
		final int MAX_LENGTH = 201;
		final int MIN_LENGTH = 0;
		if (str != null) {
			int len = str.length();
			if (MIN_LENGTH < len && len < MAX_LENGTH) {
				return true;
			}
		}
		return false;

	};// for Book//

	public static boolean isGoodIsbn(String isbn) {
		String regex = "\\d{4}-\\d{4}-\\d{1}";

		return (Pattern.matches(regex, isbn));

	};// for Book//

	public static boolean isGoodCopies(int copies) {
		final int MAX_COPIES = 20;
		final int MIN_COPIES = 0;
		if (MIN_COPIES < copies && copies < MAX_COPIES) {
			return true;
		}
		return false;

	};// for Book//

	public static boolean isGoodContext(String str) {
		final int MAX_LENGTH = 201;
		final int MIN_LENGTH = 10;
		if (str != null) {
			int len = str.length();
			if (MIN_LENGTH < len && len < MAX_LENGTH) {
				return true;
			}
		}
		return false;

	};// for newspaper//

}
