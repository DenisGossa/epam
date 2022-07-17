package typography.datavalidator;

import typography.*;

public class AtlasMapValidator {
	public static Publication validate(String[] atlasMapData) {
		final int ATLASMAP_FORMAT = 4;

		if (atlasMapData.length != ATLASMAP_FORMAT) {
			return null;
		}

		AtlasMap atlasMap = new AtlasMap();

		boolean badDataFormat = false;
		String s;

////////////// TRY SET TITLE
		s = atlasMapData[0];

		if (CheckData.isGoodTitle(s) && !badDataFormat) {
			atlasMap.setTitle(s);
		} else {
			return null;
		}
//////////////TRY SET year
		try {
			s = atlasMapData[1];
			int year = Integer.parseInt(s);
			if (!CheckData.isGoodYear(year)) {
				throw new NumberFormatException("�������� ����� � atlasMap [int year]");
			}

			atlasMap.setYear(year);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("�������� ������� atlasMap ��� [int year]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}
//////////////TRY SET category
		try {
			s = atlasMapData[2];
			Category category = Category.valueOf(s);
			atlasMap.setCategory(category);
		} catch (IllegalArgumentException ex) {
			badDataFormat = true;
			System.err.println("�������� ������ �  atlasMap ��� [category]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

//////////////TRY SET PAGES
		try {
			s = atlasMapData[3];
			int pages = Integer.parseInt(s);
			if (!CheckData.isGoodPages(pages)) {
				throw new NumberFormatException("�������� ����� � atlasMap [int pages]");
			}

			atlasMap.setPages(pages);

		} catch (NumberFormatException ex) {
			badDataFormat = true;
			System.err.println("�������� ������ � atlasMap ��� [int pages]\n" + "MUST be---WRITTEN IN LOG " + ex);
		}

		if (badDataFormat) {
			return null;
		}
		return atlasMap;

	}

}
