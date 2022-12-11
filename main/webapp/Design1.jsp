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
        <table id="table">
            <tr>
                <td>Hello</td>
            </tr>
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

        <c:set var="count" value="0" scope="page" />
        
         <c:forEach var="rowData" items="${TimeTable}">                        
          <c:set var="count" value="${count + 1}" scope="page"/>
<!--             <div class="day">             -->
                 <c:choose>
         
         <c:when test = "${count==1}">
             <div class="Monday">             
            <div class="day_title">Monday</div>
         </c:when>
            <c:when test = "${count==2}">
                <div class="Tuesday">             
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
                                <div class="hour gray"><center><c:out value="${cellData}"></center></c:out></div>                                       
                            </c:when>

                            <c:otherwise>
                                <div class="hour white"><center><c:out value="${cellData}"></center></c:out></div>                                       
                            </c:otherwise>
                        </c:choose>
                      <c:set var="count1" value="${count1 + 1}" scope="page"/>

                    </c:forEach>
                    </div>
         </c:forEach>
        <center>
        <form action="/TimeTable-DSS/TimeTable/Display" method="Post">                    
                    <div class="buttons">
            <button>Validate</button>                     
            
            <input type="submit" value="Edit">                                   
            <a href="EditSlots" >Update Slots</a>                      
            <a href="Download">Download CSV</a>
            </div>    
            </form>
        </center>
 

    </body>
          <script>
                function exportTableToCSV($table, filename) {

    var $rows = $table.find('tr:has(td),tr:has(th)'),

        // Temporary delimiter characters unlikely to be typed by keyboard
        // This is to avoid accidentally splitting the actual contents
        tmpColDelim = String.fromCharCode(11), // vertical tab character
        tmpRowDelim = String.fromCharCode(0), // null character

        // actual delimiter characters for CSV format
        colDelim = '","',
        rowDelim = '"\r\n"',

        // Grab text from table into CSV formatted string
        csv = '"' + $rows.map(function (i, row) {
            var $row = $(row), $cols = $row.find('td,th');

            return $cols.map(function (j, col) {
                var $col = $(col), text = $col.text();

                return text.replace(/"/g, '""'); // escape double quotes

            }).get().join(tmpColDelim);

        }).get().join(tmpRowDelim)
            .split(tmpRowDelim).join(rowDelim)
            .split(tmpColDelim).join(colDelim) + '"',



        // Data URI
        csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);

        console.log(csv);

        if (window.navigator.msSaveBlob) { // IE 10+
            //alert('IE' + csv);
            window.navigator.msSaveOrOpenBlob(new Blob([csv], {type: "text/plain;charset=utf-8;"}), "csvname.csv")
        } 
        else {
            $(this).attr({ 'download': filename, 'href': csvData, 'target': '_blank' }); 
        }
}

// This must be a hyperlink
$("#xx").on('click', function (event) {

    exportTableToCSV.apply(this, [$('#example1'), 'export.csv']);

    // IF CSV, don't do event.preventDefault() or return false
    // We actually need this to be a typical hyperlink
});                
            </script>
</html>
