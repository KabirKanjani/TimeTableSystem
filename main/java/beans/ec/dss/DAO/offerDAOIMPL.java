package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.faculty;
import beans.ec.dss.entities.offer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class offerDAOIMPL implements offerDAO{

    @Override
    public void addOffer(offer off) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<offer> viewOffer()
    {
        String sql="SELECT * FROM course_allocation.offer ORDER BY courseno ASC, programid ASC, semester ASC, term ASC ";        
        List<offer> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            
            while(rs.next())
            {       
                offer f1=new offer(rs.getString("courseno"),rs.getInt("programid"),rs.getInt("semester"),rs.getString("term").charAt(0));
                list.add(f1);
            }            
        } 
        catch (SQLException ex) {
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;        

    }
    
}
