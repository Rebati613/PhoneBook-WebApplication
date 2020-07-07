<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js">
</script>
<script src="js/form-validation.js"></script>
</head>
<body>
<h2><font color='blue'><b>Save Contact</b></font></h2>
<h3><font color ='green'><b>${sucMsg}</b></font></h3>
<h3><font color ='red'><b>${errMsg}</b></font></h3>

<form:form action="saveContact"
		   modelAttribute="contact" 
		   method="POST" name="registration">
<table >
<tr>
<td><form:hidden path="contactId"/></td>
</tr>
<tr>
<td>Contact Name :</td>
<td><form:input path = "contactName"/></td>
</tr>

<tr>
<td>Email id</td>
<td><form:input path = "contactEmail"/></td>
</tr>

<tr>
<td>Contact Number</td>
<td><form:input path = "contactNumber"/></td>
</tr>

<tr>
<td><input type = "reset" value = "Reset"></td>
<td><input type = "submit" value = "Save"></td>
</tr>
</table>
</form:form>
<br/>
<a href="viewContacts">View all contacts</a>
</body>
</html>