<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Categories</title>
</head>
<body>
    <%@include file="header.jsp" %> 
    <div align="center">       
        <table>
            <form action="/TimeTable-DSS/TimeTable/UpdateSlot" method="post">
            <tr>
                <th>Slot No: </th>
                <td>${SlotVal.getSlotno()}</td>
            </tr>
            <tr>
                <th>Course Code:</th>
                <td>                    
                    <input type="hidden" name="oldcoursename" size="45"
                            value="<c:out value='${SlotVal.getCourseno()}' />"                            
                        />
                    <input type="hidden" name="SlotNo" size="45"
                            value="${SlotVal.getSlotno()}"/>
                    <input type="text" name="newcoursename" size="45"
                            value="${SlotVal.getCourseno()}" />                        
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>