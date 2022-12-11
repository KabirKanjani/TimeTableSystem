package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.openfor;
import beans.ec.dss.entities.programs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class programsDAOIMPL implements programsDAO{

    @Override
    public void addPrograms(programs program) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<programs> viewPrograms() 
    {
            String sql="SELECT * FROM course_allocation.programs ORDER BY programid ASC ";        
        List<programs> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);                    
            ResultSet rs=smt.executeQuery();                
            
            while(rs.next())
            {                                       
                programs f1=new programs(rs.getString("programid"),rs.getString("programname"),rs.getInt("plabel"));
                list.add(f1);
            }            
        } 
        catch (SQLException ex) {            
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        


    }
    
}
