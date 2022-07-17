package typography.datavalidator;

import typography.*;

public class NewsPaperDataValidator {
	public static Publication validate(String[] newsPaperData) {
		final int NEWSPAPER_FORMAT = 6;

		if (newsPaperData.length != NEWSPAPER_FORMAT) {
			return null;
		}

		NewsPaper newsPaper = new NewsPaper();

		boolean badDataFormat = false;
		String s;

////////////// TRY SET TITLE
		s = newsPaperData[0];

		if (CheckData.isGoodTitle(s) && !badDataFormat) {
			newsPaper.setTitle(s);
		} else {
			return null;
		}
//////////////TRY SET number
		try {
			s = newsPaperData[1];
			int number = Integer.parseInt(s);

			if (!CheckData.isGoodNumber(number)) {
				throw new NumberFormatException("�������� ����� � NewsPaper [int number]");
			}

			newsPaper.setNumber(number);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("�������� ������ � NewsPaper ��� [int number]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET year
		try {
			s = newsPaperData[2];
			int year = Integer.parseInt(s);
			if (!CheckData.isGoodYear(year)) {
				throw new NumberFormatException("�������� ����� � NewsPaper [int year]");
			}

			newsPaper.setYear(year);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("�������� ������� NewsPaper ��� [int year]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET context
		s = newsPaperData[3];
		if (CheckData.isGoodContext(s) && !badDataFormat) {
			newsPaper.setContext(s);
		} else {
			return null;
		}

		////////////// TRY SET category
		try {
			s = newsPaperData[4];
			Category category = Category.valueOf(s);
			newsPaper.setCategory(category);
		} catch (IllegalArgumentException ex) {
			badDataFormat = true;
			System.err.println("�������� ������ �  NewsPaper ��� [category]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET PAGES
		try {
			s = newsPaperData[5];
			int pages = Integer.parseInt(s);
			if (!CheckData.isGoodPages(pages)) {
				throw new NumberFormatException("�������� ����� � NewsPaper [int pages]");
			}

			newsPaper.setPages(pages);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("�������� ������ � NewsPaper ��� [int pages]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

		if (badDataFormat) {
			return null;
		}
		return newsPaper;

	}

}