package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class coursesDAOIMPL implements coursesDAO{

    @Override
    public void AddCourse(courses course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<courses> viewCourse() {
        String sql="SELECT * FROM course_allocation.courses ORDER BY courseno ASC";        
        List<courses> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            
            while(rs.next())
            {                
                courses c1=new courses(rs.getString("courseno"),rs.getString("coursename"),rs.getString("credit"),rs.getFloat("credit_lec"),rs.getFloat("credit_tutorial"),rs.getFloat("credit_lab"),rs.getFloat("Credit_total"));
                list.add(c1);
            }            
        } 
        catch (SQLException ex) {
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
}
