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
<a href="/TimeTable-DSS/new">List All Offer</a>

</h2>
</center>
<div align="center">
<table border="1" cellpadding="5">
<caption><h2>List of Offer</h2></caption>
<tr>
<th>Course No</th>
<th>Program Id</th>
<th>semester</th>
<th>term</th>
<th>Actions</th>
</tr>
<c:forEach var="off" items="${offer}">
<tr>
<td><c:out value="${off.getCourseno()}" /></td>
<td><c:out value="${off.getProgramid()}" /></td>
<td><c:out value="${off.getSemester()}" /></td>
<td><c:out value="${off.getTerm()}" /></td>
<td>
<a href="/TimeTable-DSS/edit?id=<c:out value='${off.getCourseno()}' />">Edit</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/TimeTable-DSS/delete?id=<c:out value='${off.getCourseno()}' />">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
