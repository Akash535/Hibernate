package com.bean;

public class Book {

	private int bid;
	private  float price;
	private String bookName,authorName;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", price=" + price + ", bookName=" + bookName + ", authorName=" + authorName + "]";
	}
	
}
