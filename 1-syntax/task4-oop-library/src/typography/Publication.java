package typography;

public abstract class Publication {

	String title;
	Category category;
	int pages;
	int year;

/////////////////////////////////
	public abstract String getTitle();

	public abstract int getYear();

	public abstract Category getCategory();

	public abstract int getPages();

	Publication() {
	};

	Publication(String title, Category category, int pages, int year) {
		this.title = title;
		this.category = category;
		this.pages = pages;
		this.year = year;
	}
}
