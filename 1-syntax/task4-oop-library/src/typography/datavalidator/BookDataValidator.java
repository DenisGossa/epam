package typography.datavalidator;

import java.util.regex.Pattern;

import typography.Book;
import typography.Category;
import typography.Publication;

public class BookDataValidator {
	public static Publication validate(String[] bookData) {
		final int BOOK_FORMAT = 7;
		if (bookData.length != BOOK_FORMAT) {
			return null;
		}

		Book book = new Book();

		boolean badDataFormat = false;
		String s;
		////////////// TRY SET AUTHOR

		s = bookData[0];
		if (CheckData.isGoodAuthor(s) && !badDataFormat) {
			book.setAuthor(s);
		} else {
			return null;
		}

		////////////// TRY SET TITLE
		s = bookData[1];
		if (CheckData.isGoodTitle(s) && !badDataFormat) {
			book.setTitle(s);
		} else {
			return null;
		}
//////////////TRY SET ISBN
		s = bookData[2];
		if (CheckData.isGoodIsbn(s) && !badDataFormat) {
			book.setIsbn(s);
		} else {
			return null;
		}

//////////////TRY SET PAGES
		try {
			s = bookData[3];
			int pages = Integer.parseInt(s);
			if (!CheckData.isGoodPages(pages)) {
				throw new NumberFormatException("Неверное число  [int pages]");
			}

			book.setPages(pages);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в Book для [int pages]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

		try {
			/** SET [category]| */
			s = bookData[4];
			Category category = Category.valueOf(s);
			book.setCategory(category);
		} catch (IllegalArgumentException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в  BOOK для [category]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET year
		try {
			s = bookData[5];
			int year = Integer.parseInt(s);
			if (!CheckData.isGoodYear(year)) {
				throw new NumberFormatException("Неверное число  [int year]");
			}

			book.setYear(year);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в Book для [int pages]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET copies

		try {
			s = bookData[6];
			int copies = Integer.parseInt(s);
			if (!CheckData.isGoodCopies(copies)) {
				throw new NumberFormatException("Неверное число  [int copies]");
			}

			book.setCopies(copies);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в Book для [int copies]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}
		if (badDataFormat) {
			return null;
		}
		return book;

	}

}
