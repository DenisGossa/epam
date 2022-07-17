package typography;

public class NewsPaper extends Publication implements Comparable<NewsPaper> {

	private int number;
	private String context;/* short description of main news */

	public NewsPaper() {
	};

	public NewsPaper(String title, int number, int year, String context, 
					 Category category, int pages) {

		super(title, category, pages, year);

		this.number = number;
		this.context = context;

	}

	public void printClassInfo() {
		System.out.println(this.toString());
	}

	@Override
	public void publicationDataFormat() {
		System.out.println("[title]|[number]|[YEAR]|[context][category][pages]");
	}

	@Override
	public String toString() {
		return "NewsPaper [title=" + title + ", number=" + number + ", year=" + 
				year + ", context=" + context
				+ ", category=" + category + ", pages=" + pages + "]";
	}

////////////////////////////////////////////////////////////////////////
/// Automatic generated methods set,get,equals,hashCode
////////////////////////////////////////////////////////////////////////
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@Override
	public int compareTo(NewsPaper np) {
		return title.compareTo(np.getTitle());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + number;
		result = prime * result + pages;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewsPaper other = (NewsPaper) obj;
		if (category != other.category)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (number != other.number)
			return false;
		if (pages != other.pages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

}
