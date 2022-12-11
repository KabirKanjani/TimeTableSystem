<%@page contentType="text/html" pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Slots</title>
    <style>
        a
        {
            text-decoration:none;
            color:white;
            font-family: sans-serif;
	font-weight: 100;        
        }
        
a {
  text-decoration:none;
  border: 2px solid #00ACEC;
  padding:10px 20px 10px 20px;
  border-radius:2px;
  color:White;
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
      /* Dropdown Button */
      .dropbtn {
        border:0;
background:black;
display:block;
margin:20px auto;
text-align:center;
border:2px solid #3498db;
padding:14px 10px;
width:200px;
outline:none;
color:white;
border-rdius:24px;

      }

      /* The container 
				<div> - needed to position the dropdown content */
      .dropdown {
        z-index:9999;
        display: inline-block;                
      }

      /* Dropdown Content (Hidden by Default) */
      .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
        z-index: 1;
      }

      /* Links inside the dropdown */
      .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
      }

      .center {
        margin : auto;
        width:min-content;        
      }

      /* Change color of dropdown links on hover */
      .dropdown-content a:hover {
        background-color: #ddd;
      }

      /* Show the dropdown menu on hover */
      .dropdown:hover .dropdown-content 
      {           
        display: block;
      }

      /* Change the background color of the dropdown button when the dropdown content is shown */
      .dropdown:hover .dropbtn {
        width:280px;
border-color:#2ecc71;	

      }
    </style>
  </head>
  <body>
      
      
 
      
        <c:set var="count" value="0" scope="page" />
        <form action="/TimeTable-DSS/TImeTable/EditSlots?Val=${param.Val}" method="POST">
            <div class="container">
                            <div class="dropdown">
      <button class="dropbtn">Select Slot </button>
      <div class="dropdown-content">
        <c:forEach var="cellData" varStatus="loop" items="${KeyList}">
          <a href="EditSlots?Val=${cellData}">${cellData}</a>
        </c:forEach>
      </div>
    </div>

        <Table>

              <tr>
            <th>Slot No</th>
            <th>Course No</th>
            <th colspan=2>Actions</th>
              </tr>
        </thead>          
        <tbody>
          <c:forEach var="cellData" varStatus="loop" items="${SlotValue}">
            <tr>
              <td>${param.Val}</td>
              <td>
                  ${cellData}
                <c:set var="count" value="${count + 1}" scope="page"/>
              </td>
              <td><a href="/TimeTable-DSS/TimeTable/UpdateSlots?Val=${param.Val}&OldVal=${cellData}">Edit</a></td>
              <td><a href="">Delete</a></td>
            </tr>
          </c:forEach>
        </tbody>
        </Table>        
        <input type="hidden" name="length" value="${count}"/>
<!--        <center><input type="submit"></center>-->
        </form>
      </div>    
  </body>
</html>