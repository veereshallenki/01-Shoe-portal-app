<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category home page</title>
</head>
<body>
${requestScope.msg}
<h2> Configure categories</h2>
<form action="storecategory" method="post">

<label> Category Name </label>
		<input type="text" name="catname" maxlength=20 > </br></br>

 <input type="submit" value="Configure Category"> 
		 <input type="reset" value="reset">  
		
		
		
</form>

</body>
</html>