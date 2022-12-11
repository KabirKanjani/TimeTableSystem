package beans.ec.dss.Servlet;

import beans.ec.dss.DAO.CategoriesDAOIMPL;
import beans.ec.dss.DAO.MainDAOIMPL;
import beans.ec.dss.DAO.coursesDAOIMPL;
import beans.ec.dss.DAO.facultyAssignedDAOIMPL;
import beans.ec.dss.DAO.facultyDAOIMPL;
import beans.ec.dss.DAO.offerDAOIMPL;
import beans.ec.dss.DAO.openForDAOIMPL;
import beans.ec.dss.DAO.programsDAOIMPL;
import beans.ec.dss.DAO.slotAssignedDAOIMPL;
import beans.ec.dss.DAO.timetableDAOIMPL;
import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.categories;
import beans.ec.dss.entities.courses;
import beans.ec.dss.entities.faculty;
import beans.ec.dss.entities.facultyassigned;
import beans.ec.dss.entities.offer;
import beans.ec.dss.entities.openfor;
import beans.ec.dss.entities.programs;
import beans.ec.dss.entities.slotassigned;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerServlet extends HttpServlet
{
    @Override
    public void init()
    {
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {      
        String action=request.getServletPath();
        System.out.println(action);
        switch(action)
        {
        
         case "/Homepage":
        {
            Homepage(request,response);
            break;
        }
         case "/TimeTable/UpdateSlot":
         {
            try {
                UpdateSlot(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             break;
         }

         case "/TimeTable/Display":
            {
                DisplayEditTable(request,response);
                break;
                }                    
            case "/TimeTable/Edit":
            {
            try {
                EditTimeTable(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            case "/EditSlots":
            {
                System.out.println("POST");
                UpdateSlots(request,response);
                break;
            }
              case "/Send":                
              {
                Homepage(request, response);
                break;
              }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
    {        
        String action=request.getServletPath();
                       System.out.println(request.getPathInfo());
        System.out.println(action);
        String[] split = action.substring(1,action.length()).split("/");
        System.out.println(Arrays.toString(split));
        System.out.println(split[0]);
        if("".equals(split[0]))
        {            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");        
            dispatcher.forward(request, response);   
        }
        if("ImportData".equals(split[0]))
        {
            ImportData(request,response);
        }
        if("EditSlots".equals(split[0]))
        {         
            System.out.println("LA");
                UpdateSlots(request,response);                
        }
                if("EditSlots".equals(split[0]))
        {         
            System.out.println("LA");
                UpdateSlots(request,response);                
        }


        if("ExportData".equals(split[0]))
        {            
            ExportData(request,response);            
        }
        
        if("Display".equals(split[1]))
        {                
                DisplayTable(request,response);            
            
        }
        if("Edit".equals(split[0]))
        {
            try {           
                EditTimeTable(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
                switch(split[1])
                {
                    case "Download":
                    {
                        DownloadCSV(request,response);
                        break;
                    }
                    case "view":
                    {
                        mainmain(request,response,split[0]);
                        break;     
                    }
                    case "Export":
                {
                    DisplayExportTable(request,response,split[0]);
                }
                    case "edit":
                    {
                        try {
                            showEditForm(request, response,split[0]);
                        } catch (SQLException ex) {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                }
                    case "Update":
                    {
                        try {
                            UpdateRecord(request, response,split[0]);
                        } catch (SQLException ex) {
                            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
          
         case "EditSlots":
            {
                System.out.println("PT");
                EditSlots(request,response);
                break;
                }                    
         case "UpdateSlots":
            {
                UpdateSlots(request,response);
                break;
                }                    
         case "/TimeTable/Display":
            {
                DisplayTable(request,response);
                break;
                }                    
            case "/new":
        {
            try {
                DisplayForm(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
            case "/insert":
                InsertForm(request,response);
                break;
            case "/insertRecord":
        {
            try {
                InsertRecord(request,response);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;

            case "delete":
        {
            try {
                deleteRecord(request, response,split[0]);
            } catch (SQLException ex) {
                Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                break;
         
            default:                
                System.out.println("K");
                Homepage(request, response);
                break;
        }
        }
    }


    private void DisplayForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, IOException, IOException 
    {
        CategoriesDAOIMPL cdi=new CategoriesDAOIMPL();
        List<categories> CategoryList=cdi.ListCourses();
        System.out.println(CategoryList);
        request.setAttribute("CategoryList",CategoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("WebForm.jsp");                
        dispatcher.forward(request, response);
    }

    private void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditForm.jsp");
        dispatcher.forward(request, response);
    }
    private void InsertRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException 
    {
        String categoryname = request.getParameter("categoryname");        
        categories category=new categories(categoryname);        
        CategoriesDAOIMPL cdi=new CategoriesDAOIMPL();
        cdi.InsertRecord(category);
        response.sendRedirect("/TimeTable-DSS/new");
    }

    private void deleteRecord(HttpServletRequest request, HttpServletResponse response,String tablename) throws IOException, SQLException 
    {
        System.out.println("AAO");
        String columnname=(String) request.getParameter("columnname");
        System.out.println(columnname);
        String columnval=(String) request.getParameter(columnname);        
        String sql="DELETE FROM course_allocation."+tablename+" WHERE "+columnname+"='"+columnval+"';";                
        System.out.println(sql);
        try (Connection cn = DBCon.getConnection()) {
            PreparedStatement smt=cn.prepareStatement(sql);
            
            smt.executeQuery();
        }
        catch(Exception e)
        {
            
        }
         response.sendRedirect("http://localhost:8080/TimeTable-DSS/"+tablename+"/view");
        
        
    }

    
    private void showEditForm(HttpServletRequest request, HttpServletResponse response,String tablename) throws SQLException, ServletException, ServletException, SQLException, IOException 
    {
        String columnname=request.getParameter("columnname");
        String value=request.getParameter(columnname);
        MainDAOIMPL mdi=new MainDAOIMPL();       
        TreeMap<String,String> map=mdi.UpdateData(tablename,columnname,value);        
        RequestDispatcher dispatcher = request.getRequestDispatcher("../EditForm.jsp");
        request.setAttribute("MapData",map);                
        dispatcher.forward(request, response);   
    }

    private void listForm(HttpServletRequest request, HttpServletResponse response) 
    {       
        
    }

    private void UpdateRecord(HttpServletRequest request, HttpServletResponse response,String name) throws SQLException, IOException, ServletException 
    {                    
            HashMap<String,String> map=new HashMap<>();
            String sql="SELECT * FROM course_allocation."+name+" order by 1";                
            try {
                    Connection cn = DBCon.getConnection();
                    PreparedStatement smt=cn.prepareStatement(sql);        
                    ResultSet rs=smt.executeQuery();                
                    ResultSetMetaData rsmt=rs.getMetaData();
                    int columncount=rsmt.getColumnCount();
                    System.out.println(columncount);
                    System.out.println(rs);
                    int row = 0;                        

                  if(rs.next())
                   {
                       sql="Update course_allocation."+name+" SET";
                      for (int i = 1; i <=columncount; i++)
                        {
                            String nae=rsmt.getColumnName(i);
                            String type=rsmt.getColumnTypeName(i);  
                            if("numeric".equals(type)||"int4".equals(type))
                            {
                                sql+=" "+nae+"="+request.getParameter(nae)+" ";
                            }
                            else
                            {
                                sql+=" "+nae+"='"+request.getParameter(nae)+"'";
                            }
                               if(i<columncount)
                            {
                                sql+=" , ";
                            }
                                                        
                         }
                      sql+=" WHERE";
                      for(int i=1;i<=columncount;i++)
                      {
                            String nae=rsmt.getColumnName(i);
                            String type=rsmt.getColumnTypeName(i);  
                            if("numeric".equals(type)||"int4".equals(type))
                            {
                                sql+=" "+nae+"="+request.getParameter("D"+nae)+" ";
                            }
                            else
                            {
                                sql+=" "+nae+"='"+request.getParameter("D"+nae)+"' ";
                            }
                            if(i<columncount)
                            {
                                sql+=" AND ";
                            }
                      }
                       sql+=";";
                       System.out.println(sql);
                       
                    }  
                  smt=cn.prepareStatement(sql);        
                       smt.executeUpdate();
                       cn.close();
                       response.sendRedirect("http://localhost:8080/TimeTable-DSS/"+name+"/view");
           }              
                    catch(SQLException e)
                    {
                        Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, e);
                    }
    }
    private void DisplayTable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {    
        try
        {            
            timetableDAOIMPL ttd=new timetableDAOIMPL();
            String str[][]=ttd.viewTimeTable();
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<5;j++)
                {
                    System.out.print(str[i][j]+"\t");
                }
                System.out.println();
            }
            req.setAttribute("TimeTable",str);
            RequestDispatcher dispatcher=req.getRequestDispatcher("../check.jsp");                        
            dispatcher.forward(req, resp);   
        }
        catch(ServletException | IOException e)
        {
        }RequestDispatcher dispatcher=req.getRequestDispatcher("../ErrorPage.jsp");                        
            dispatcher.forward(req, resp);   
    }

    private void DisplayEditTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {        
        timetableDAOIMPL ttd=new timetableDAOIMPL();
        String str[][]=ttd.viewTimeTable();
        
        request.setAttribute("TimeTable",str);
        RequestDispatcher dispatcher=request.getRequestDispatcher("../EditTimeTable.jsp");                        
        dispatcher.forward(request, response);   

    }

    private void EditTimeTable(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
    {
        String str[][]=new String[8][5];
        for (int i = 0; i <8; i++) 
        {
            for(int j=1;j<=5;j++)
            {                                
                str[i][j-1]=request.getParameter(i+""+(j));
                System.out.print(str[i][j-1]+"\t");
            }
            System.out.println("");
        }
        timetableDAOIMPL ttd=new timetableDAOIMPL();        
        request.setAttribute("TimeTable",ttd.UpdateTimeTable(str));        
        RequestDispatcher dispatcher=request.getRequestDispatcher("../check.jsp");                        
        dispatcher.forward(request, response);   
    }

    private void EditSlots(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String Val="";
        Val=request.getParameter("Val");
        slotAssignedDAOIMPL sad=new slotAssignedDAOIMPL();        
        if(Val=="")
        {        
            HashMap<String ,ArrayList<String>> map=sad.viewSlotAssigned();  
    //        ArrayList<String> list=map.get(request.getParameter("slotno"));
            ArrayList<String> KeyList=new ArrayList<>();
            for(String key:map.keySet())
            {
                KeyList.add(key);
            }
            request.setAttribute("KeyList",KeyList);
            RequestDispatcher dispatcher=request.getRequestDispatcher("../UpdateSlots.jsp");                        
            dispatcher.forward(request, response);   
        }
        else
        {
           HashMap<String ,ArrayList<String>> map=sad.viewSlotAssigned();  
           ArrayList<String> list=map.get(Val);
               ArrayList<String> KeyList=new ArrayList<>();
            for(String key:map.keySet())
            {
                KeyList.add(key);
            }
            request.setAttribute("KeyList",KeyList);
        
           request.setAttribute("SlotValue",list);
           RequestDispatcher dispatcher=request.getRequestDispatcher("../UpdateSlots.jsp");                        
           dispatcher.forward(request, response);   
        }
    }

    private void UpdateSlots(HttpServletRequest request, HttpServletResponse response) throws ServletException, ServletException, IOException 
    {
        String slotno=request.getParameter("Val");
        String courseid=(String) request.getParameter("OldVal");
        System.out.println(courseid);
        slotassigned sa=new slotassigned(slotno,courseid);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../EditSlots.jsp");
        request.setAttribute("SlotVal",sa);                        
        dispatcher.forward(request, response);           
    }

    private void UpdateSlot(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException 
    {
        System.out.println("Hell");
        String SlotNo=request.getParameter("SlotNo");
        String OldCourse=request.getParameter("oldcoursename");
        String NewCourse=request.getParameter("newcoursename");
        slotAssignedDAOIMPL sadi=new slotAssignedDAOIMPL();
        sadi.updateSlots(SlotNo,OldCourse,NewCourse);
        response.sendRedirect("http://localhost:8080/TimeTable-DSS/TimeTable/EditSlots?Val="+SlotNo);
    }
    private void Homepage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if("admin".equals(username)&&"admin".equals(password))
        {   
            HttpSession session=request.getSession();
            session.setAttribute("message","Login Succesful");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Homepage.jsp");
            dispatcher.forward(request, response);   
        } else {
        }
    }

    private void viewCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException 
    {
        coursesDAOIMPL cdi=new coursesDAOIMPL();
        List<courses> list=cdi.viewCourse();
        System.out.println(list.toString());
        request.setAttribute("Course",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCourse.jsp");
        dispatcher.forward(request, response);   
        
    }

    private void viewFaculty(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException 
    {
        facultyDAOIMPL fdi=new facultyDAOIMPL();
        List<faculty> list=fdi.viewFaculty();
        System.out.println(list.toString());
        request.setAttribute("faculty",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewFaculty.jsp");        
        dispatcher.forward(request, response);   
    
        
        
    }

    private void viewFacultyAssigned(HttpServletRequest request, HttpServletResponse response) throws ServletException, ServletException, IOException 
    {
        facultyAssignedDAOIMPL fad=new facultyAssignedDAOIMPL();
        List<facultyassigned> list=fad.viewFacultyAssigned();
        System.out.println(list.toString());
        request.setAttribute("FacultyAssigned",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("FacultyAssigned.jsp");                
        dispatcher.forward(request, response);      
        
    }

    private void viewOffer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        offerDAOIMPL odi=new offerDAOIMPL();
        List<offer> list=odi.viewOffer();
        System.out.println(list.toString());
        request.setAttribute("offer",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("offer.jsp");                
        dispatcher.forward(request, response);      

    }

    private void viewOpenfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openForDAOIMPL ofd=new openForDAOIMPL();
        List<openfor> list=ofd.viewOpenFor();
        System.out.println(list.toString());
        request.setAttribute("openfor",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("openfor.jsp");                
        dispatcher.forward(request, response);      

    }

    private void viewPrograms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException 
    {
        programsDAOIMPL pdi=new programsDAOIMPL();
        List<programs> list=pdi.viewPrograms();
        System.out.println(list.toString());
        request.setAttribute("programs",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("programs.jsp");                        
        dispatcher.forward(request, response);      
       
    }

    private void mainmain(HttpServletRequest request, HttpServletResponse response,String tablename) throws ServletException, ServletException, ServletException, IOException, ServletException, ServletException 
    {
        MainDAOIMPL mdi=new MainDAOIMPL();        
        HashMap<Integer,List<String>> map=mdi.viewCourse(tablename);           
        System.out.println(map.toString());
        request.setAttribute("MainMain",map);
        request.setAttribute("tablename",tablename);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../mainmain.jsp");                                        
        dispatcher.forward(request, response);      
        
    }

    private void TableList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
            MainDAOIMPL mdi=new MainDAOIMPL();
            List<String> list=mdi.getTableName("");
            System.out.println(list.toString());
            request.setAttribute("TableList",list);            
            RequestDispatcher dispatcher=request.getRequestDispatcher("TableList.jsp");                
            dispatcher.forward(request, response);
 
    }

    private void DownloadCSV(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
      timetableDAOIMPL ttd=new  timetableDAOIMPL();                        
      String [][] str=ttd.viewTimeTable();
            request.setAttribute("TimeTable",str);            
            RequestDispatcher dispatcher=request.getRequestDispatcher("../check.jsp");                
            dispatcher.forward(request, response);
 

    }

    private void ExportData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
                    MainDAOIMPL mdi=new MainDAOIMPL();
            List<String> list=mdi.getTableName("");
            System.out.println(list.toString());
            request.setAttribute("TableList",list);            
            RequestDispatcher dispatcher=request.getRequestDispatcher("ExportList.jsp");                
            dispatcher.forward(request, response);

    }

    private void DisplayExportTable(HttpServletRequest request, HttpServletResponse response, String tablename) throws ServletException, IOException 
    {       
            MainDAOIMPL mdi=new MainDAOIMPL();        
        HashMap<Integer,List<String>> map=mdi.viewCourse(tablename);           
        System.out.println(map.toString());
        request.setAttribute("MainMain",map);        
        request.setAttribute("tablename",tablename);
        RequestDispatcher dispatcher = request.getRequestDispatcher("../ViewExport.jsp");                                                
        dispatcher.forward(request, response);      
    
    }

    private void ImportData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        MainDAOIMPL mdi=new MainDAOIMPL();
            List<String> list=mdi.getTableName("");
            System.out.println(list.toString());
            request.setAttribute("TableList",list);            
            RequestDispatcher dispatcher=request.getRequestDispatcher("ImportList.jsp");                
            dispatcher.forward(request, response);

    }
    
    
}
 
