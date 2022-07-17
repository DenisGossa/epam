package typography.datavalidator;

import typography.*;

public class JournalDataValidator {
	public static Publication validate(String[] journalData) {
		final int JOURNAL_FORMAT = 5;
		if (journalData.length != JOURNAL_FORMAT) {
			return null;
		}

		Journal journal = new Journal();
		boolean badDataFormat = false;
		String s;

////////////// TRY SET TITLE
		s = journalData[0];
		if (CheckData.isGoodTitle(s) && !badDataFormat) {
			journal.setTitle(s);
		} else {
			return null;
		}
//////////////TRY SET category
		try {
			s = journalData[1];
			Category category = Category.valueOf(s);
			journal.setCategory(category);
		} catch (IllegalArgumentException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в  Journal для [category]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET PAGES
		try {
			s = journalData[2];
			int pages = Integer.parseInt(s);
			if (!CheckData.isGoodPages(pages)) {
				throw new NumberFormatException("Неверное число в Journal [int pages]");
			}

			journal.setPages(pages);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в Journal для [int pages]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}
//////////////TRY SET number
		try {
			s = journalData[3];
			int number = Integer.parseInt(s);
			if (!CheckData.isGoodNumber(number)) {
				throw new NumberFormatException("Неверное число в Journal [int number]");
			}

			journal.setNumber(number);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный формат в Journal для [int number]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET year
		try {
			s = journalData[4];
			int year = Integer.parseInt(s);
			if (!CheckData.isGoodYear(year)) {
				throw new NumberFormatException("Неверное число в Journal [int year]");
			}

			journal.setYear(year);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("Неверный форматв Journal для [int year]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}
		if (badDataFormat) {
			return null;
		}
		return journal;

	}

}
