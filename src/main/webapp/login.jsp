<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<form action="checkuser" method="post">
		<label> email id </label>
		<input type="email" name="email"> </br></br>
		<label> Password </label>
		 <input type="password" name="password"> </br> </br> 
		 <input type="submit" value="submit"> 
		 <input type="reset" value="reset">  
		</from>
</body>
</html>