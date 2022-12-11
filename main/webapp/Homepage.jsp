
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>

.column {     
      justify-content: center;
  align-items: center;

 }

.row
{
    margin: auto;    
      width: 100%;              
}

.column 
{
  border:0;
  text-decoration: none;
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
.column:hover
{
    width:280px;
border-color:#2ecc71;	

}


html, body {
  height: 100%;
  margin: 0;
  overflow:hidden;
}
     h1{
     font-family:"Times New Roman";
 }
a
{
   color:white;
   text-decoration:none;
}

        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>        
<%@include file="header.jsp" %>
<%@include file="message.jsp" %>
        <br>
                <div class="row">
                    <a href="TimeTable/Display"><div class="column">Edit TimeTable</div></a>
                    <a  href="TableList"><div class="column">Edit Data</div></a>
                    <a  href="AddUser"><div class="column"> Add User</div></a>
                    <a  href="ExportData"><div class="column"> Export Data</div></a>
                    <a  href="ImportData"><div class="column"> Import Data</div></a>
                </div>
    </body>
</html>
