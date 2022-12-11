package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.faculty;
import beans.ec.dss.entities.facultyassigned;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class facultyAssignedDAOIMPL implements facultyassignedDAO
{

    @Override
    public void addFacultyAssigned(facultyassigned facA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<facultyassigned> viewFacultyAssigned() 
    {
        String sql="SELECT * FROM course_allocation.facultyassigned ORDER BY courseno ASC, shortname ASC ";        
        List<facultyassigned> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            
            while(rs.next())
            {       
                facultyassigned fa1=new facultyassigned(rs.getString("courseno"),rs.getString("shortname"),rs.getString("section"));
                list.add(fa1);
            }            
        } 
        catch (SQLException ex) {
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        
        
    }
    
}
