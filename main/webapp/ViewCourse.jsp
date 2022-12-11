<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses List</title>
</head>
<body>
    <center>
        <h1>List Courses</h1>
        <h2>
            <a href="/TimeTable-DSS/insert">Add New Courses</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/TimeTable-DSS/new">List All Courses</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Courses</h2></caption>
            <tr>
                <th>Course No</th>
                <th>Course Name</th>
                <th>Credit</th>
                <th>Credit lec</th>               
                <th>Credit tutorial</th>
                <th>Credit lab</th>                                
                <th>Credit total</th>                
                <th>Actions</th>
            </tr>
            <c:forEach var="course" items="${Course}">
                <tr>
                    <td><c:out value="${course.getCourseno()}" /></td>                    
                    <td><c:out value="${course.getCoursename()}" /></td>                    
                    <td><c:out value="${course.getCredit()}" /></td>                    
                    <td><c:out value="${course.getCredit_lec()}" /></td>
                    <td><c:out value="${course.getCredit_tutorial()}" /></td>                    
                    <td><c:out value="${course.getCredit_lab()}" /></td>                    
                    <td><c:out value="${course.getCredit_total()}" /></td>                    

                    
                    
                    <td>    
                        <a href="/TimeTable-DSS/edit?id=<c:out value='${course.getCourseno()}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/TimeTable-DSS/delete?id=<c:out value='${course.getCourseno()}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>