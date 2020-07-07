<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script >
function deleteFunction() {
	return confirm("Are you sure,want to delete");
}
</script>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function() {
    $('#contact_tbl').DataTable( {
        "pagingType": "full_numbers"
    } );
} );
</script>
</head>
<body>
<h2><a href="addContact"><b>+Add new contact</b></a></h2>
<br/>
<table border="1" id="contact_tbl">
<thead>
<tr>
<th>Sl No.</th>
<th>Contact Name</th>
<th>Contact Email</th>
<th>Contact Number</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${contacts}" var="c" varStatus="index">
<tr>
<td>${index.count}</td>
<td>${c.contactName}</td>
<td>${c.contactEmail}</td>
<td>${c.contactNumber}</td>
<td><a href="editContact?cid=${c.contactId}">Edit</a>
	<a href="deleteContact?cid=${c.contactId}" onclick="deleteFunction()">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>