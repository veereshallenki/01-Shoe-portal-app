<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset password home page</title>
</head>
<body>
<h2> Change password</h2>
<form action="chgpwd" method="post">

<label> Email Id  </label>

<input type="email" name="email"> </br></br>
<label> Password </label>
		 <input type="password" name="password"> </br> </br> 
	
<label> Re enter Password </label>
		 <input type="password" name="password2"> </br> </br>
		
		 <input type="submit" value="ChangePassword"> 
		 <input type="reset" value="reset">   
		  		 

</form>
</body>
</html>