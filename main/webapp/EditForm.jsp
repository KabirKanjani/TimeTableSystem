<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="ErrorPage.jsp"%>
<html>
<head>
    <style>
               
            input[type="text"] {
    width: 100%;
    padding: 10px;
    margin: 0px;
}
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
	top: 55%;	
        left:60%;
       
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
    <title>Edit Details</title>
</head>
<body>
    <%@include file="header.jsp" %> 
    <div class="container">        
        <form action="Update" method="GET">                 
        <table>                        
                <c:forEach var="map" items="${MapData}">
                    <tr>
                        <td>
                            ${map.key}
                        </td> 
                        <td>
                            <input type="text" value="${map.value}" name="${map.key}">
                        </td>
                        <input type="hidden" value="${map.value}" name="D${map.key}">
                    </tr>
                </c:forEach>
                    <tr>
                        <td colspan="2"><input type="submit" value="submit" class='buttons' > </td>
                    </tr>                                   
            
        </table>         
</form>            
    </div>   
</body>
</html>