package beans.ec.dss.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main 
{
    public static void main(String[] args) throws SQLException {                
        Connection cn=DBCon.getConnection();
        cn.setSchema("course_allocation");
        String sql="Select * from courses";
	PreparedStatement smt;
        try {
                smt=cn.prepareStatement(sql);
                ResultSet rs=smt.executeQuery();
                while(rs.next())
                {
                    System.out.println(rs.getString("courseno"));
                }
            }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
}
