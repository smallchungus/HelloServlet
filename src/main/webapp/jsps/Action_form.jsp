<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<h1>Login Page Or Search</h1>
	<form action ="<%= request.getContextPath() %>/register" method="POST">
		<input type="text" name="username"> <br /> 
		<input type="text" name="password" /> <br /> 
		<input type="submit" value="submit" /> <br />
	</form>
	
	<form action ="<%= request.getContextPath() %>/search" method="POST">
		<input type="text" name="search"><br />
		<input type="submit" value="searchThis" /> 
	</form>
	
</body>
</html>