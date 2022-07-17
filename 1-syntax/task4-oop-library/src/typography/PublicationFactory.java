package typography;

import java.io.*;

import java.util.regex.*;
import typography.datavalidator.*;
import java.util.*;

public class PublicationFactory {

	public List<Publication> getPublication() {

		String strLine;
		List<Publication> publicationList = new ArrayList<Publication>();
		/// check file length==0/// return null||exeption

		try {
			FileInputStream fstream = new FileInputStream("c:\\Publication.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			while ((strLine = br.readLine()) != null) {

				if (strLine.length() != 0 && !strLine.contains("[")) {
					Publication validatedPublication = validatePublicationData(strLine);
					if (validatedPublication != null) {
						publicationList.add(validatedPublication);
					}
					;
				}
			}
			br.close();

		} catch (IOException e) {
			System.err.println("Error in opening file");
		}

		System.out.printf("List contains %d elements \n", publicationList.size());
		// System.out.printf("TreeSet contains %d elements \n", publicationSet.size());

		for (Publication state : publicationList)
			System.out.println(state);

		if (publicationList.size() == 0)
			return null;
		return publicationList;
	}

	Publication validatePublicationData(String str) {
		Publication publication = null;
		Pattern pattern = Pattern.compile("\\|");
		String[] publicationData;

		if (str.contains("BOOK: ")) {

			str = str.replace("BOOK: ", "");
			publicationData = pattern.split(str, 0);
			publication = BookDataValidator.validate(publicationData);

		}
		if (str.contains("JOURNAL: ")) {

			str = str.replace("JOURNAL: ", "");
			publicationData = pattern.split(str, 0);
			publication = JournalDataValidator.validate(publicationData);
		}

		if (str.contains("NEWSPAPER: ")) {

			str = str.replace("NEWSPAPER: ", "");
			publicationData = pattern.split(str, 0);
			publication = NewsPaperDataValidator.validate(publicationData);
		}

		if (str.contains("ATLASMAP: ")) {

			str = str.replace("ATLASMAP: ", "");
			publicationData = pattern.split(str, 0);
			publication = AtlasMapValidator.validate(publicationData);
		}

		return publication;

	}

}
