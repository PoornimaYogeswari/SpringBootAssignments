package com.training.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Library {

	@Autowired
	private Book book;


	public void displayBookDetails() {
		System.out.println("Book Details.....");
		System.out.println("Author:" + book.getAuthor() +" Title:"+ book.getTitle());
	}

}
