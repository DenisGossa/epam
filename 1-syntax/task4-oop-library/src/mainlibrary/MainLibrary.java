package mainlibrary;
import typography.*;

public class MainLibrary {
	public static void main(String[] args) {
		final String TITLE = "Мир"; 
		final Category NAME_Category = Category.HISTORY;

		PublicationFactory typography = new PublicationFactory();
		Library library = new Library(typography.getPublication());

		System.out.println("________________Find by Category");
		System.out.println("library.findByCategory(" + NAME_Category + ")");
		library.printResult(library.findByCategory(NAME_Category)); 
		System.out.println("_____________________________________");

		///////////////////////////////////////////////////////////////////////
		System.out.println(
				"There are  pages by Category-" + NAME_Category + ": " 
						+ library.countPagesByCategory(NAME_Category));

		//////////////////////////////////////////////////////////////////////
		System.out.println("_____________________________________");

		System.out.println("library.findByTitle: " + "\"" + TITLE + "\"");
		library.sortByTitleAndYear(library.findByTitle(TITLE));
		library.printResult();
	}
}
