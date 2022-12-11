
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
                    html,
body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 800px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
}

th,
td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #fff;
}

th,td,tr {
	text-align: center;
}

thead {
	th {
		background-color: #55608f;
	}
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
                text-align:center;
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
}
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %> 
    <center>
        
        <h1>Import Table</h1>
        <form action="./upload" method="post" enctype="multipart/form-data" id="tableform">        
            <table>
                <tr>
                    <td>
            <label for="tablename">Choose Table to Import:</label>
                    </td>
                    <td>
            <select name="tablename" id="tablename" form="tableform">
            <c:forEach  var="TableName" items="${TableList}">                    
                        <option value="${TableName}">${TableName}</option>
            </c:forEach>
            </select>
            </td>
            <tr>
                <td>Choose Import File:</td>
                <td ><input type="file" name="file" required/></td>
            </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Import"></td>
            </tr>
        </form>
    </center>
    </body>
</html>
