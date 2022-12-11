<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Categories List</title>
</head>
<body>
<center>
<h1>List Programs</h1>
<h2>
<a href="/TimeTable-DSS/insert">Add New Program</a>
&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/new">List All Programs</a>

</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of Programs</h2></caption>
<tr>
<th>Program Id</th>
<th>Program Name</th>
<th>Program Label</th>
<th>Actions</th>
</tr>
<c:forEach var="pg" items="${programs}">
<tr>
<td><c:out value="${pg.getProgramid()}" /></td>
<td><c:out value="${pg.getProgramname()}" /></td>
<td><c:out value="${pg.getPlabel()}" /></td>
<td>
<a href="/TimeTable-DSS/edit?id=<c:out value='${pg.getProgramid()}' />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/delete?id=<c:out value='${pg.getProgramid()}' />">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
