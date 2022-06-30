<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<a href="loadform">+Add new contact</a>
<title>Insert title here</title>


<script type="text/javascript">
function showpopup(){

	return confirm("Are you sure, you want to delete this record?");
}


</script>
</head>
<body>
<table border="1">
<thead>
<tr>
<td>Contact Nmae</td>
<td>Contact Number</td>
<td>Contact Email</td>
<td>Action</td>
</tr>
</thead>

<tbody >
<c:forEach items="${contact}" var="c">
<tr>
<td>${c.contactName}</td>
<td>${c.contactNumber}</td>
<td>${c.contactEmail}</td>
<td>
<a href="edit?cid=${c.contactId}">Edit</a> &nbsp;
<a href="delete?cid=${c.contactId}" onclick="return confirm()">delete</a>

</td>

</tr>


</c:forEach>


</tbody>




</table>
</body>
</html>