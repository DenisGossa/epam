package typography;

public class Journal extends Publication implements Comparable<Journal> {
	private int number;
	
	public Journal(){};
	public Journal(String title, Category category, int pages,	int number,int year){
		super(title,category,pages,year);
				
		this.number=number;
		
	}
////////////////////////////////////////////////////////////////////////
/// automatic generated Set() , Get()
////////////////////////////////////////////////////////////////////////	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public void printClassInfo() {
		System.out.println(	);
	}	
	
	@Override
	public void publicationDataFormat() {
		System.out.println("[title]|[category|[pages]|[number]|[year]");
	}
	@Override
	public int compareTo(Journal j){
		return title.compareTo(j.getTitle());
	}
	
@Override
	public String toString() {
		return "Journal [title=" + title + ", category=" + category + ", pages=" 
				+ pages + ", number=" + number + ", year="
				+ year + "]";
	}
	////////////////////////////////////////////////////////////////////////
/// automatic generated equals() , hashCode()
////////////////////////////////////////////////////////////////////////
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Journal other = (Journal) obj;
		if (category != other.category)
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
