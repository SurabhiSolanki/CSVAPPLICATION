package com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.model.Book;

public class BookDAO implements BookDAOInter {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
        this.jdbcUsername = "root";
        this.jdbcPassword = "solanki017";
    }
     
    public void connect() {
    	try {
    		if (jdbcConnection == null || jdbcConnection.isClosed()) {
    			try {
    				Class.forName("com.mysql.jdbc.Driver");
    			} catch (ClassNotFoundException e) {
    				throw new SQLException(e);
            }
            
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
    		}
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    }
     
    public void disconnect()  {
    	try {
    		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
    			jdbcConnection.close();
    		}
    	}catch(SQLException ex) {
    		ex.printStackTrace();
    	}
    }
     
    public boolean insertBook(Book book)  {
    	 boolean rowInserted=false;
    	try {
        String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setFloat(3, book.getPrice());
       
        
         
        rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        }catch (Exception e) {
			e.printStackTrace();
		}
    	
        return rowInserted;
    }
     
    public List<Book> listAllBooks()  {
    	Statement statement= null;
    	ResultSet resultSet= null;
    	List<Book> listBook = new ArrayList<>();
    	try {
        
         
        String sql = "SELECT * FROM book";
         
        connect();
         
        statement = jdbcConnection.createStatement();
        resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("book_id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
            
             
            Book book = new Book(id, title, author, price);
            listBook.add(book);
        }
    	
        resultSet.close();
        statement.close();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
         
        disconnect();
         
        return listBook;
    }
     
    public boolean deleteBook(Book book)  {
    	boolean rowDeleted = false;
    	try {
    	String sql = "DELETE FROM book where book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        }catch (Exception e) {
			e.printStackTrace();
		}
        disconnect();
        return rowDeleted;     
    }
     
    public boolean updateBook(Book book)  {
    	boolean rowUpdated= false;
    	try {
        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
        sql += " WHERE book_id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setFloat(3, book.getPrice());
        statement.setInt(4, book.getId());
        rowUpdated = statement.executeUpdate() > 0;
        statement.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
        disconnect();
        return rowUpdated;     
    }
    
    
    public Book getBook(int id) {
    	Book book = null;
    	try {
    	
        String sql = "SELECT * FROM book WHERE book_id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
             
            
            
            book = new Book(id, title, author, price);
        }
         
        resultSet.close();
        statement.close();
        }catch (Exception e) {
			e.printStackTrace();
		}
        return book;
    }
}
