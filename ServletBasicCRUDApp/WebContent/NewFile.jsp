<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <html> <head><title>c:out JSTL core tag example</title> </head>
    	<body> <c:out value="This is a c:out JSTL core tag example."/><br/>Sum of 10 and 20 = 		             
    	 <c:out  value="${10+20}"/><br/><br/>
                            <c:out value="${'<h6>This is a <c:out> escape XML test </h6>'}"/>
                            
                            
                            <c:set var="website" value="www.google.com"/>
		<a href><c:out value="${website}"/></a>
                            
   	  </body>
     </html>
    

</body>
</html>