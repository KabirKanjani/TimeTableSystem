package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAOIMPL implements categoriesDAO
{
    
    @Override
    public void addCategory(categories category) {        
    }

    @Override
    public void viewCategory(categories category) {        
    }
    public List<categories> ListCourses() throws SQLException
    {
        List<categories> listCategories=new ArrayList<>();
        String sql="SELECT * FROM course_allocation.categories ORDER BY categoryid ASC ";
        Connection cn=DBCon.getConnection();
        PreparedStatement smt;
        smt=cn.prepareStatement(sql);        
        ResultSet rs=smt.executeQuery();                
        while(rs.next())
        {
            int id=rs.getInt("categoryid");
            String catname=rs.getString("categoryname");
            categories category=new categories(id,catname);
            listCategories.add(category);
        }
        rs.close();
        return listCategories;                               
    }    
    public boolean updateCategory(categories Category) throws SQLException   
    {
        String sql="Update course_allocation.categories set categoryname=? where categoryid=?";
        Connection cn=DBCon.getConnection();
        
        boolean rowsUpdated;
        try (PreparedStatement statement = cn.prepareStatement(sql)) {
            statement.setString(1,Category.getCategoryname());
            statement.setInt(2,Category.getCategoryid());
            rowsUpdated = statement.executeUpdate()>0;
        }
        return rowsUpdated;          
    }
    public categories GetCategory(int id) throws SQLException
    {
        categories category=null;
        String sql="SELECT * FROM course_allocation.categories where categoryid=? ORDER BY categoryid ASC";
        Connection cn=DBCon.getConnection();
        PreparedStatement smt;
        smt=cn.prepareStatement(sql);
        smt.setInt(1, id);
        ResultSet rs= smt.executeQuery();
        if(rs.next())
        {            
            String categoryname=rs.getString("categoryname");
            category=new categories(id,categoryname);
        }
        rs.close();
        smt.close();
        return category;
    }

    public void InsertRecord(categories category) throws SQLException
    {        
       String sql="select count(*) from  course_allocation.categories";             
       Connection cn=DBCon.getConnection();       
       System.out.println(1);
       Statement stmt=cn.createStatement();
       ResultSet rsmt=stmt.executeQuery(sql);
       System.out.println(2);
       rsmt.next();
       System.out.println(3);
       int count = rsmt.getInt(1);           
       System.out.println(count);
       sql="insert into course_allocation.categories values(?,?)";
       PreparedStatement smt;
       smt=cn.prepareStatement(sql);
       smt.setInt(1, count+1);
       smt.setString(2,category.getCategoryname());
       smt.executeUpdate();
       smt.close();
       rsmt.close();       
    }

    public void deleteRecord(categories Category) throws SQLException 
    {
        int id=Category.getCategoryid();
        String sql="delete from course_allocation.categories where categoryid=?";
        PreparedStatement smt;
        Connection cn=DBCon.getConnection();       
        smt=cn.prepareStatement(sql);
        smt.setInt(1, id);
        smt.executeUpdate();
        smt.close();        
    }
}