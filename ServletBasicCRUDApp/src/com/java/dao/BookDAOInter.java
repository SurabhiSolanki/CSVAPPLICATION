package com.java.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.model.Book;

public interface BookDAOInter {

	 public void connect() ;
	 public void disconnect();
	 public boolean insertBook(Book book);
	 public boolean deleteBook(Book book);
	 public List<Book> listAllBooks();
	 public boolean updateBook(Book book);
	 public Book getBook(int id);
	 
	
}
