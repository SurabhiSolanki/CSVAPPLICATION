<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/ServletBasicCRUDApp/new">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/ServletBasicCRUDApp/list">List All Books</a>
             
        </h2>
        <form method="post" action="/ServletBasicCRUDApp/details">
         <table>
    	<tr>
            <td>
               Search
            </td>
            <td>
            <input type="text" name="search" placeholder="Search">
            </td>
        </tr>
    </table>
    </form>
    </center>
   
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="/ServletBasicCRUDApp/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/ServletBasicCRUDApp/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>
