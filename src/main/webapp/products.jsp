<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products home page</title>
</head>
<body>
${requestScope.msg}
<h2> Product configurations</h2>
<form action="storeproduct" method="post">

<label> Product Name </label>
		<input type="text" name="name"> </br></br>
<label> Product price </label>
		<input type="text" name="price"> </br></br>
<label> Product category </label>
		<input type="text" name="categoryid"> </br></br>

 <input type="submit" value="Configure Product"> 
		 <input type="reset" value="reset">  

</form>
</body>
</html>