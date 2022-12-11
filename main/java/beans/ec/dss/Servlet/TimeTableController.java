package beans.ec.dss.Servlet;

import beans.ec.dss.DAO.timetableDAOIMPL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeTableController extends HttpServlet
{
    @Override
    public void init()
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
        
        String action=req.getServletPath();
        System.out.println("HEL"+action);
        switch(action)
        {
            case "/Display":
        {
            DisplayTable(req,resp);
            break;
            }
        }
    }

    private void DisplayTable(HttpServletRequest req, HttpServletResponse resp) 
    {
        System.out.println("Hello");
        timetableDAOIMPL ttd=new timetableDAOIMPL();
        ttd.viewTimeTable();
    }
    
}
