package beans.ec.dss.Servlet;

import beans.ec.dss.Utils.DBCon;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sendData extends HttpServlet
{
    private String message;
    public void init() throws ServletException
    {

    }
       
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
         response.setContentType("text/html");

      // Actual logic goes here.
      
            message="Initiated";
        try{
            Connection cn=DBCon.getConnection();
        cn.setSchema("course_allocation");
        String sql="Select * from courses";
	PreparedStatement smt;
                smt=cn.prepareStatement(sql);
                ResultSet rs=smt.executeQuery();                
                      PrintWriter out = response.getWriter();
                      String data="";
      
                while(rs.next())
                {
                    data+="<tr>"
                            + "<td>"+rs.getString("courseno")+"</td><td>"+rs.getString("courseno")+"</td><td>"+rs.getString("courseno")+"</td><td>"+rs.getString("courseno")+"</td><td><a href=\"/edit?id="+4+"/>\">Edit</a></td><td><a href=\"/delete?id="+4+"/>\">Delete</a></td></tr>";                    
                }
                out.println(""
              + "<html>"
              + "<head>"
              + "<title>Table for Data</title>"
              + "</head>"
              + "<body><center><h1>Info Detials for Student</h1><center>"
              + "<table border><th colspan=4>Info Details for Student</th>"+data+"</table></html>");
            }                
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    {
    }
}
