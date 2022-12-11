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
 #MyInput
{
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
border-radius:24px;
transition:0.25s;
}
#MyInput input[type="text"]:focus
{
width:280px;
border-color:#2ecc71;	
}
    </style>
    <title> List</title>
</head>
<body>    
    
    <div align="center">
        <input type="text" name="" id="MyInput" placeholder="Search.." onkeyup="SearchFunc()">
                      <c:forEach var="col" items="${MainMain}" begin="0" end="0">
                          <c:set var="column" value="${col.value[0]}" scope="page"></c:set>                    
                    </c:forEach>
 
        <table id="MyTable">
            <tbody>
            <c:forEach var="entry" items="${MainMain}">  
                <tr>                                    
                    <c:forEach var="col" items="${entry.value}">                      
                        <td><c:out value="${col}"></c:out></td>                    
                    </c:forEach>
                         <c:choose>
                            <c:when test="${entry.key!=0}">
                          <td>
                               <a href="/TimeTable-DSS/${tablename}/edit?columnname=${column}&${column}=<c:out value='${entry.value.get(0)}' />">Edit</a>
                        </td>
                        <td>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="/TimeTable-DSS/${tablename}/delete?columnname=${column}&${column}=<c:out value='${entry.value.get(0)}' />">Delete</a>                     
                        </td>
                            </c:when>    
                            <c:otherwise>
                                <td colspan="2">Actions</td>
                            </c:otherwise>
                        </c:choose>
                        
                        
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>   
</body>
<script>
    const SearchFunc=()=>
    {   
        let filter=document.getElementById("MyInput").value.toUpperCase();
        let MyTable=document.getElementById("MyTable");
        let tr=MyTable.getElementsByTagName("tr");
        for(var i=1;i<tr.length;i++)
        {
            let td=tr[i].getElementsByTagName('td')[1];
            if(td)
            {
                let textvalue=td.textContent||td.innerHTML;
                if(textvalue.toUpperCase().indexOf(filter)>-1)
                {
                    tr[i].style.display="";
                }
                else
                {
                    tr[i].style.display="none";
                }
            }
        }
    }
    </script>
</html>