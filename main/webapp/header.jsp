<%-- 
    Document   : header.jsp
    Created on : 16 Nov, 2022, 9:46:47 PM
    Author     : Paresh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

        <style>
            
            input[type="text"] {
    width: 100%;
    padding: 10px;
    margin: 0px;
}

table .last, td:last-child { 
    padding: 2px 24px 2px 0px; 
}

                        .header1
            {
                overflow:auto;
                margin-top:0;
            }
            .header1 h1{                
                float:left;
            }            
           .buttons > a, button,input[type="submit"] 
            {
              background-color: rgba(52, 73, 94,0.9);
              border: none;
              color: white;
              padding: 15px 32px;
              text-align: center;
              text-decoration: none;
              display: inline-block;
              font-size: 16px;
            }
            tr:first-child , td:first-child
            {
                font-weight: bold;
            }
           .buttons
           {
               display:inline-block;
           }
        *{
    box-sizing: border-box;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
}
body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
            -webkit-font-smoothing: antialiased;

} 

h2{
    text-align: center;
    font-size: 18px;
    text-transform: uppercase;
    letter-spacing: 1px;
    color: white;
    padding: 30px 0;
}
   
        </style>
    </head>
    <body>            
                    <div class="header1">
             <!--<img src="img/logo.png" alt=".">--> 
             <h1>DAIICT-TimeTable System</h1>
        </div>
    </body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>        
</html>
