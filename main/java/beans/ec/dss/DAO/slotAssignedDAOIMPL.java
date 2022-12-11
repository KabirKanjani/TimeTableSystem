package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.slotassigned;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class slotAssignedDAOIMPL implements slotassignedDAO{

    @Override
    public void addSlotAssigned(slotassigned sa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap<String,ArrayList<String>> viewSlotAssigned() 
    {
        String sql="SELECT * FROM time_table.slotassigned ORDER BY slotno ASC, courseno ASC";
        try {
            Connection cn=DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);
            ResultSet rsmt=smt.executeQuery();
            HashMap<String,ArrayList<String>> map=new HashMap<>();
            while(rsmt.next())
            {                           
                ArrayList<String> list=(ArrayList<String>) (map.get(rsmt.getString("slotno"))==null? new ArrayList<>() : map.get(rsmt.getString("slotno")));
                list.add(rsmt.getString("courseno"));                
                map.put(rsmt.getString("slotno"),list);
            }
            cn.close();
            return map;
            
        } catch (SQLException ex) {
            Logger.getLogger(slotAssignedDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public void updateSlots(String SlotNo, String OldCourse, String NewCourse) throws SQLException
    {
            String sql="Update time_table.slotassigned Set courseno=? where courseno=? AND slotno=?";            
            Connection cn=DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);
            smt.setString(1,NewCourse);
            smt.setString(2,OldCourse);
            smt.setString(3, SlotNo);
            smt.executeUpdate();        
            cn.close();
    }
    
}
