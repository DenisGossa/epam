package mainlibrary;
import java.util.*;
import typography.*;
import comparator.*;

public class Library {
	private List<Publication> publicationList;
	private List<Publication> resultPublicationList = new ArrayList<Publication>();
	private List<Publication> bookList = new ArrayList<Publication>();

	Library() {};

	Library(List<Publication> publicationList) {
		this.publicationList = publicationList;
	}

	public void setPublicationList(List<Publication> publicationList) {
		this.publicationList = publicationList;
	}

	public List<Publication> getBookList() {
		return bookList;
	}

	void printResult() {
		printResult(resultPublicationList);
	}

	void printResult(List<Publication> list) {
		if (list.size() == 0 || list == null) {
			System.out.println("No such items at the Library..");
			return;
		}
		System.out.println("Results:");
		for (Publication result : list) {
			System.out.println(result);
		}

	}

	
	/*sort*/
	void sortByTitle(List<Publication> list) {
		if (list != null) {
			list.sort(new SortByTitleComparator());
		}

		else {
			throw new NumberFormatException("Список пуст");//
			// System.out.println("No such items by Title:");
		}
	}

	void sortByTitleAndYear(List<Publication> list) {
		if (list == null || list.size() == 0) {
			System.out.println("No such items by ByTitleAndYear:");
		} else {
			list.sort(new SortByTitleComparator().thenComparing(new SortByYearComparator()));
		}
	}

	public List<Publication> findByTitle(String title) {
		resultPublicationList.clear();

		if (title == null || title.length() == 0) {
			return resultPublicationList;
		}
		String elementTitle;
		for (Publication current : publicationList) {
			elementTitle = current.getTitle();
			if (elementTitle.contains(title)) {
				resultPublicationList.add(current);
			}
		}
		// список может возвратиться пустым
		return resultPublicationList;
	}

	public List<Publication> findByAuthor(String author) {
		String elementAuthor;
		List<Publication> tmpbookList = new ArrayList<Publication>();

		bookList.clear();
		resultPublicationList.clear();
		bookList = findAllBooks();

		if (bookList == null || bookList.size() == 0) {
			return bookList;
		}

		for (Publication current : bookList) {
			elementAuthor = ((Book) current).getAuthor();
			if (elementAuthor.contains(author)) {
				tmpbookList.add(current);
			}
		}
		// список может возвратиться 0 размера
		return tmpbookList;
	}

	public List<Publication> findByCategory(Category category) {
		resultPublicationList.clear();
		if (publicationList.size() == 0 || publicationList == null) {
			// add my exeption
			// + "Can't find sum of the pages");
			System.out.println("Cant find by category. No Category");
			return resultPublicationList;
		}

		for (Publication current : publicationList) {
			if (category == current.getCategory()) {
				resultPublicationList.add(current);
			}
		}
		// список может возвратиться пустым
		return resultPublicationList;
	}

	int countPagesByCategory(Category category) {
		if (category == null) {
			return 0;
		}
		resultPublicationList = findByCategory(category);
		if (resultPublicationList.size() == 0 || resultPublicationList == null) {
			// add my exeption
			// throw new NumberFormatException("List is empty."
			// + "Can't find sum of the pages");
			System.out.println("Cant find sum. No list");
			return 0;
		}
		int countPages = 0;
		for (Publication current : resultPublicationList) {
			countPages += current.getPages();
		}
		return countPages;
	}
	public List<Publication> findAllBooks() {
		List<Publication> tmpBookList = new ArrayList<Publication>();
		if (publicationList == null || publicationList.size() == 0) {
			return tmpBookList;
		}
		for (Publication current : publicationList) {

			if (current instanceof Book) {
				tmpBookList.add(current);
			}
		}
		bookList = tmpBookList;
		return tmpBookList;
	}
}
