package typography;

public class AtlasMap extends Publication implements Comparable<AtlasMap> {    
	
	public AtlasMap(){};
	AtlasMap(String title,Category category, int year,int pages){
		super(title,category,pages,year);
	}
	
	
	public void printClassInfo() {
		System.out.println(	this.toString());
	}	
	
	@Override
	public void publicationDataFormat() {
		System.out.println("[title]|[year]|[CATEGORY][pages]");
	}
	@Override
	public int compareTo(AtlasMap at){ 
		return title.compareTo(at.getTitle());
	}
////////////////////////////////////////////////////////////////////////
/// Auto generated methods
////////////////////////////////////////////////////////////////////////
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		AtlasMap other = (AtlasMap) obj;
		if (category != other.category)
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

	@Override
	public String toString() {
		return "AtlasMap [title=" + title + ", year=" + year + ", category=" + 
				category + ", pages=" + pages + "]";
	}
	
	
	
}
