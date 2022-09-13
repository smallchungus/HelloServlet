<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Form Processing</h1>
	
	<p>
		<b>Did this work User:</b>
		<%=request.getParameter("username")%>

	    <%
          String name = request.getParameter("username");
          String text = request.getParameter("password");
        
          FileWriter myWriter = new FileWriter("filename.txt");
          myWriter.write("am i writing anything please");
          myWriter.write("Username " + name +"<BR>");
          myWriter.write("Password " + text +"<BR>");
          myWriter.close();


        %>
</p>

</body>
</html>