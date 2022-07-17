package typography;

public class Book extends Publication implements Comparable<Book> {
	private  String author;
	private  String isbn;
	private  int copies;
	
	public Book(){};
	public Book(String title, String author, String isbn,	int pages,Category category,int year,int copies){
		
		super(title,category,pages,year);
		
		this.author=author;
		this.isbn=isbn;
		this.copies=copies;
		
		
	}
////////////////////////////////////////////////////////////////////////
/// automatic genered Set() , Get()
////////////////////////////////////////////////////////////////////////	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCopies() {
		return copies;
	}
	public void setCopies(int copies) {
		this.copies = copies;
	}

	public void printClassInfo() {
		System.out.println(	this.toString());
	}
	
	
	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", pages=" + 
				pages + ", category=" + category + ", year="
				+ year + "]";
	}
	@Override
	public void publicationDataFormat() {
			System.out.println("BOOK: [author]|[title]|[isbn]|[pages]|[category]|"
								+ "[year]");
	}
	
	@Override
	public int compareTo(Book b){ 
		return title.compareTo(b.getTitle());
	}
	
////////////////////////////////////////////////////////////////////////
/// automatic genered equals() , hashCode()
////////////////////////////////////////////////////////////////////////
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category != other.category)
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
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
