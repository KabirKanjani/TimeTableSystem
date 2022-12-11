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
<th>Course No</th>
<th>Short Name</th>
<th>Section</th>
<th>Actions</th>
</tr>
<c:forEach var="FA" items="${FacultyAssigned}">
<tr>
<td><c:out value="${FA.getCourseno()}" /></td>
<td><c:out value="${FA.getShortname()}" /></td>
<td><c:out value="${FA.getSection()}" /></td>
<td>
<a href="/TimeTable-DSS/edit?id=<c:out value='${FA.getShortname()}' />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/delete?id=<c:out value='${FA.getShortname()}' />">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
