package org.comstudy21.model;

public class Product {
	private int idx;
	private String title;
	private int price;
	
	public Product() {
		idx = 0;
		title = "";
		price = 0;
	}

	public Product(int idx, String title, int price) {
		this.idx = idx;
		this.title = title;
		this.price = price;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [idx=" + idx + ", title=" + title + ", price=" + price + "]";
	}
	
	@Override
	public int hashCode() {
		return idx;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product p = (Product)obj;
			if(idx == p.getIdx()) {
				return true;
			}
		}
		return false;
	}
	
}
