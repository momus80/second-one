package util;

public class DTO {
	private String title;
	private String name;
	private String price;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String toString() {
		String str = null;
		str = String.format("%5d, %-8s, %-8s", title,name,price);
		return str;
	}
}
