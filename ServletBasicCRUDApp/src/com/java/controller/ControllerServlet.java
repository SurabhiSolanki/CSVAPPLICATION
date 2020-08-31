package com.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.java.dao.BookDAO;
import com.java.model.Book;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private static final String SAVE_DIR = "WebContent\\images";
	    private BookDAO bookDAO;
	 //?autoReconnect=true&useSSL=false
	    public void init() {
	        String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
	        String jdbcUsername = "root";
	        String jdbcPassword = "solanki017";
	 
	        bookDAO = new BookDAO(jdbcURL, jdbcUsername, jdbcPassword);
	 
	    }
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        doGet(request, response);
	    }
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String action = request.getServletPath();
	        System.out.print("Hello"+action);
	 
	        try {
	            switch (action) {
	            case "/new":
	                showNewForm(request, response);
	                break;
	            case "/insert":
	                insertBook(request, response);
	                break;
	            case "/delete":
	                deleteBook(request, response);
	                break;
	            case "/edit":
	                showEditForm(request, response);
	                break;
	            case "/update":
	                updateBook(request, response);
	                break;
	            default:
	                listBook(request, response);
	                break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	 
	    private void listBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
	        List<Book> listBook = bookDAO.listAllBooks();
	        request.setAttribute("listBook", listBook);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookList.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Book existingBook = bookDAO.getBook(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("BookForm.jsp");
	        request.setAttribute("book", existingBook);
	        dispatcher.forward(request, response);
	 
	    }
	 
	    
	    private void insertBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	        
	   
	        Book newBook = new Book(title, author, price);
	        bookDAO.insertBook(newBook);
	        response.sendRedirect("list");
	    }
	 
	    private void updateBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        float price = Float.parseFloat(request.getParameter("price"));
	        /*String absolutePath = request.getServletContext().getRealPath("");
	        String savePath = absolutePath + File.separator + SAVE_DIR;

	        File imageSaveDirectory = new File(savePath);
	        if (!imageSaveDirectory.exists()) {
	            imageSaveDirectory.mkdir();
	        }*/
	      
	        Book book = new Book(id, title, author, price);
	        bookDAO.updateBook(book);
	        response.sendRedirect("list");
	    }
	 
	    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	 
	        Book book = new Book(id);
	        bookDAO.deleteBook(book);
	        response.sendRedirect("list");
	 
	    }
	

}
