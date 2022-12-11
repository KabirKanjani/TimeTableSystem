<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans:300,400,600);

html, body { height: 100%; margin: 0; }
body {
  font-family: 'Open Sans', sans-serif;
  color: #efefef;  
}

.day {
  width: 18%;
  height: 90vh;
  float: left;
  background-color: #fff;
  background-size: 1px 20%;
}

.day.time { width: 10%; }

.day_title {
  height: 10%;
  background-color: #34495e;
  font-size: 12px;
  font-weight: 600;
  text-transform: uppercase;
  text-align: center;
  line-height: 10vh;
}

.hour {
  height: 10%;
  background-color: rgba(52, 73, 94,0.9);
  font-size: 12px;
  text-align: center;
  line-height: 10vh;
}

.class {
  width: 100%;
  height: 15vh; /*90min*/
  line-height: 15vh;
  background-color:gray;
  font-size: 2vw;
  font-weight: 300;
  padding-left: 10px;
}

.white {
background-color:white;
color:black;
}
.gray { background-color: #bdc3c7; color: #202020; }
.spacing { background-color: transparent; }
           .buttons > a, button,input[type="submit"] 
            {
              background-color:rgba(52, 73, 94,0.9);
              border: none;
              color: white;
              padding: 15px 32px;
              text-align: center;
              text-decoration: none;
              display: inline-block;
              font-size: 16px;
            }
           .buttons
           {
               justify-content: center;               
           }




    </style>
    </head>
    <body>
        <div class="day time">
	<div class="day_title">Time</div>
	<div class="hour">H1</div>
	<div class="hour">H2</div>
	<div class="hour">H3</div>
	<div class="hour">H4</div>
	<div class="hour">H5</div>
	<div class="hour">H6</div>
	<div class="hour">H7</div>
	<div class="hour">H8</div>	
</div>
<form action="/TimeTable-DSS/TimeTable/Edit" method="Post">
        <c:set var="count" value="0" scope="page" />
        
         <c:forEach var="rowData" items="${TimeTable}">                        
          <c:set var="count" value="${count + 1}" scope="page"/>
             <div class="day">             
                 <c:choose>
         
         <c:when test = "${count==1}">
            <div class="day_title">Monday</div>
         </c:when>
            <c:when test = "${count==2}">
            <div class="day_title">Tuesday</div>
         </c:when>
            <c:when test = "${count==3}">
            <div class="day_title">Wednesday</div>
         </c:when>
            <c:when test = "${count==4}">
            <div class="day_title">Thursday</div>
         </c:when>
            <c:when test = "${count==5}">
            <div class="day_title">Friday</div>
         </c:when>         
      </c:choose>                         
                 <c:set var="count1" value="0" scope="page" />
                    <c:forEach var="cellData" varStatus="loop" items="${rowData}" >
                         <c:choose>
                            <c:when test = "${(count1+count)%2==0}">                               
                                <div class="hour gray"><center><input type="text" value='<c:out value="${cellData}"></c:out>' name="${count1}${count}"></center></div>                                       
                            </c:when>

                            <c:otherwise>
                                <div class="hour white"><center><input type="text" value='<c:out value="${cellData}"></c:out>' name="${count1}${count}"></center></div>                                       
                            </c:otherwise>
                        </c:choose>
                      <c:set var="count1" value="${count1 + 1}" scope="page"/>

                    </c:forEach>
                    </div>
         </c:forEach>
    <center>
                    <div class="buttons">
            <button>Validate</button>                     
            
            <input type="submit">                                   
            <a href="EditSlots" >Update Slots</a>               
            </div>
    </center>
            </form>

    </body>
</html>
