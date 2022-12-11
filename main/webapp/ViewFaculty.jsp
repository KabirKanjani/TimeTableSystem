<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Categories List</title>
</head>
<body>
<center>
<h1>List Categories</h1>
<h2>
<a href="/TimeTable-DSS/insert">Add New faculty</a>
&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/new">List All Categories</a>

</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of Faculties</h2></caption>
<tr>
<th>ShortName</th>
<th>FullName</th>
<th>Visiting Faculty</th>
<th>Actions</th>
</tr>
<c:forEach var="faculty" items="${faculty}">
<tr>
<td><c:out value="${faculty.getShortname()}" /></td>
<td><c:out value="${faculty.getFullname()}" /></td>
<td><c:out value="${faculty.getVisitingfaculty()}" /></td>
<td>
<a href="/TimeTable-DSS/edit?id=<c:out value='${faculty.getShortname()}' />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/delete?id=<c:out value='${faculty.getShortname()}' />">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
