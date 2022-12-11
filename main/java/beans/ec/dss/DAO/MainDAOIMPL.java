package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainDAOIMPL implements MainDAO
{ 


    @Override
    public HashMap<Integer,List<String>> viewCourse(String name)
    {    
        HashMap<Integer,List<String>> map=new HashMap<>();
        String sql="SELECT * FROM course_allocation."+name+" order by 1";        
        List<Object> list=new ArrayList<>();
        try {
            Connection cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            ResultSetMetaData rsmt=rs.getMetaData();
            int columncount=rsmt.getColumnCount();
            System.out.println(columncount);
            System.out.println(rs);
            int row = 0;
            
            if(rs.next()){
                map.put(0,new ArrayList<String>());
                map.put(++row,new ArrayList<String>());
                               for (int i = 1; i <=columncount; i++)
                {
                    String nae=rsmt.getColumnName(i);
                    String type=rsmt.getColumnTypeName(i);  
                    System.out.println(nae+""+type);
                        if("varchar".equals(type)||"bpchar".equals(type))
                        {                                
                           map.get(0).add(nae);
                        map.get(row).add(rs.getString(nae));                                

                        }
                            else if("numeric".equals(type)||"int4".equals(type))
                            {                                                                
                             map.get(0).add(nae);
                                 map.get(row).add(String.valueOf(rs.getInt(nae)));                                 
                             
                            }
 
                 }
            }
            
            while(rs.next())
            {
                map.put(++row, new ArrayList<String>());
                for (int i = 1; i <=columncount; i++)
                {
                    String nae=rsmt.getColumnName(i);
                    String type=rsmt.getColumnTypeName(i);                                        
                        if("varchar".equals(type)||"bpchar".equals(type))
                        {                                
                            System.out.println(rs.getString(nae));
                        map.get(row).add(rs.getString(nae));                                

                        }
                            else if("numeric".equals(type)||"int4".equals(type))
                            {                                                                
                            
                                System.out.println(rs.getInt(nae));
                                 map.get(row).add(String.valueOf(rs.getInt(nae)));                                 
                             
                            }
 
                 }
                
            }          
            cn.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(coursesDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        System.out.println(map.toString());        
        return map;
    }
    public TreeMap<String,String> UpdateData(String tablename,String columnname,String value)
    {                
        String sql="SELECT * FROM course_allocation."+tablename+" where "+columnname+"='"+value+"';";                
        System.out.println(sql);
        System.out.println(columnname);
        Connection cn;
        TreeMap<String,String> map=new TreeMap<>();
        try {
            cn = DBCon.getConnection();
            PreparedStatement smt=cn.prepareStatement(sql);        
            ResultSet rs=smt.executeQuery();                
            ResultSetMetaData rsmt=rs.getMetaData();
            int columncount=rsmt.getColumnCount();
            System.out.println(columncount);
            System.out.println(rs);
            
            
            
            
            
                        if(rs.next()){                
             for (int i = 1; i <=columncount; i++)
                {
                    String nae=rsmt.getColumnName(i);
                    String type=rsmt.getColumnTypeName(i);  
                    System.out.println(nae+""+type);
                        if("varchar".equals(type)||"bpchar".equals(type))
                        {                                
                           map.put(nae,rs.getString(nae));                        

                        }
                            else if("numeric".equals(type)||"int4".equals(type))
                            {                                                                                             
                                 map.put(nae,String.valueOf(rs.getInt(nae)));                                 
                             
                            }
 
                 }
            }

            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return map;
    }    
   
    public static void main(String[] args) {        
    }

    @Override
    public List<String> getTableName(String name) 
    {
        List<String> list=new ArrayList<>();
        try {
            Connection conn = DBCon.getConnection();                    
            DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();
            ResultSet tables = metaData.getTables(null, "course_allocation", null, new String[] {"TABLE"});
            while (tables.next()){
                list.add(tables.getString("TABLE_NAME"));
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }        
     return list;       
    }
}
