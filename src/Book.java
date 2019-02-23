
public class Book implements Comparable<Book> {

	String author = "";
	String name = "";
	String id = "";
	String price = "";
	String stock = "";

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
	
	public int compareTo(Book compareBook) {
		
		int compareId = Integer.parseInt(((Book) compareBook).getId()); 
		int a = Integer.parseInt(this.id);
		//ascending order
		return a - compareId;
		
		//descending order
		//return compareId - a;
		
	}

}
