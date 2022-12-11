<% 
    String message=(String) session.getAttribute("message");
    if(message!=null)
    {
    }
%>
<div class="alert alert-success alert-dismissible">  
  <strong><%=message%></strong>
  <a href="#" class="close" style="float:right" data-bs-dismiss="alert" aria-label="close">&times;</a>
</div>

<%    
    session.removeAttribute("message");
%>