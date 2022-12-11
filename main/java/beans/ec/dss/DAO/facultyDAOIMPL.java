package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class facultyDAOIMPL implements facultyDAO{

    @Override
    public void addFaculty(faculty fac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override    
    public List<faculty> viewFaculty() 
    {
String sql="SELECT * FROM course_allocation.faculty ORDER BY shortname ASC ";        
        List<faculty> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            
            while(rs.next())
            {       
                faculty f1=new faculty(rs.getString("shortname"),rs.getString("fullname"),rs.getString("visitingfaculty"));
                list.add(f1);
            }            
        } 
        catch (SQLException ex) {
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
    }

    
}
