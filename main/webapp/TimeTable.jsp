<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TimeTable</title>
    </head>
    <body>
       
       <%@include file="header.jsp" %> 
    <center><h1>TimeTable</h1></center>    
        <div align="center">
            <form action="/TimeTable-DSS/TimeTable/Display" method="Post">                
        <table border="1" cellpadding="5">            
                <tr> 
                 <th>Time</th>
                <th>MON</th>
                <th>TUE</th>                
                <th>WED</th>
                <th>THU</th>
                <th>FRI</th>
            </tr>
            <c:set var="count" value="0" scope="page" />
            <c:forEach var="rowData" items="${TimeTable}">
        <tr>
            <c:set var="count" value="${count + 1}" scope="page"/>
            <td><b>H<c:out value="${count}"></b></c:out></td>
            <c:forEach var="cellData" varStatus="loop" items="${rowData}" >
                <td><c:out value="${cellData}"></c:out></td>                    
            </c:forEach>
        </tr>
    </c:forEach>
        </table>           
            <input type="submit" value="Edit">            
            </form>
    </div>   

    </body>
    
</html>
