package com.codeTest.spring.vo;

public class Book {
	private int bookId, rental;
	private String bookName;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getRental() {
		return rental;
	}
	public void setRental(int rental) {
		this.rental = rental;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
}
