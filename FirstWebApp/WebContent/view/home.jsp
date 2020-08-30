<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.java.Railway" %>
<!DOCTYPE html>

<!--  JSP---- Java Server Pages  -->
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> i reach in home.jsp</h1>
<%  //scriptlet tag 

//String name=(String) request.getAttribute("name");
//String pass=(String) request.getAttribute("password");
//out.print("name="+name+":Password:"+ pass);
Railway obj=(Railway)request.getAttribute("rail");
out.println(obj.getUsername()+":password="+obj.getPassword()+"FromStation="+obj.getFromStation());

%>
</body>
</html>