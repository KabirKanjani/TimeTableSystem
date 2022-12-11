package beans.ec.dss.DAO;

import beans.ec.dss.Utils.DBCon;
import beans.ec.dss.entities.timetable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class timetableDAOIMPL implements timetableDAO{

    @Override
    public void addTimeTable(timetable tt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] viewTimeTable()
    {
        String sql="SELECT * FROM time_table.timetable ORDER BY day ASC, hour ASC, slotno ASC ";
        PreparedStatement smt;
        String[][] str=new String[8][5];
        try {   
            
            Connection cn=DBCon.getConnection();
            smt=cn.prepareStatement(sql);
            ResultSet rsmt=smt.executeQuery();            
            while(rsmt.next())
            {
                String day=rsmt.getString("day");
                int hour=Integer.parseInt(rsmt.getString("hour").substring(1,2));
                String slotno=rsmt.getString("slotno");
                
                switch(day){
                    case "MON":
                        str[hour-1][0]=slotno;
                        break;
                    case "TUE":
                        str[hour-1][1]=slotno;
                        break;
                    case "WED":
                        str[hour-1][2]=slotno;
                        break;
                    case "THU":
                    str[hour-1][3]=slotno;
                    break;
                    case "FRI":
                    str[hour-1][4]=slotno;
                    break;
                }
                
            }
          cn.close();
            return str;
        } catch (SQLException ex) {
            Logger.getLogger(timetableDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        return null;        
    }
    public String[][] UpdateTimeTable(String[][] str) throws SQLException
    {        
        Connection cn=DBCon.getConnection();
        String day="";        
        for(int i=0;i<str.length;i++)        
        {
            for(int j=0;j<str[i].length;j++)
            {
                    switch(j+1){
                    case 1:
                        day="MON";
                        break;
                    case 2:
                        day="TUE";
                        break;
                    case 3:
                        day="WED";
                        break;
                    case 4:
                    day="THU";
                    break;
                    case 5:
                    day="FRI";
                    break;
                }        
                
                System.out.println("CHEESE");                
                String sql="Update time_table.timetable set slotno=? where day=? AND hour=?";
                PreparedStatement statement=cn.prepareStatement(sql);                
                System.out.println(str[i][j]);
                statement.setString(1,str[i][j]);
                statement.setString(2,day);
                statement.setString(3,"H"+(i+1));
                System.out.println(statement);
                int bool=statement.executeUpdate();
                System.out.print(bool);
            }            
            System.out.println("");
        }
        cn.close();
        return str;
    }
    public void DownloadTimeTable(String path) throws FileNotFoundException
    {
        String sql="SELECT * FROM time_table.timetable ORDER BY day ASC, hour ASC, slotno ASC ";
        PreparedStatement smt;
        String[][] str=new String[8][5];
        try {   
            
            Connection cn=DBCon.getConnection();
            smt=cn.prepareStatement(sql);
            ResultSet rsmt=smt.executeQuery();            
            while(rsmt.next())
            {
                String day=rsmt.getString("day");
                int hour=Integer.parseInt(rsmt.getString("hour").substring(1,2));
                String slotno=rsmt.getString("slotno");
                
                switch(day){
                    case "MON":
                        str[hour-1][0]=slotno;
                        break;
                    case "TUE":
                        str[hour-1][1]=slotno;
                        break;
                    case "WED":
                        str[hour-1][2]=slotno;
                        break;
                    case "THU":
                    str[hour-1][3]=slotno;
                    break;
                    case "FRI":
                    str[hour-1][4]=slotno;
                    break;
                }
                
            }
            File csv=new File(path+".csv");
            PrintWriter out=new PrintWriter(csv);
            String str1[][]=new String[5][8];
            for(int i=0;i<=8;i++)
                {
                    if(i==0)
                    {
                        out.print("Time,"+"Monday,"+"Tuesday,"+"Wednesday,"+"Thursday,"+"Friday,");
                    }
                    else
                    {
                        out.print("H"+i+",");
                    }
                    for(int j=0;j<5;j++)
                    {
                        
                        if(i==0)
                            break;
                        str1[j][i-1]=str[i-1][j];
                        out.print(str1[j][i-1]+",");
                        
                        
                    }
                    out.println();
                    System.out.println("");                    
                }
            out.close();
            cn.close();            
        } catch (SQLException ex) {
            Logger.getLogger(timetableDAOIMPL.class.getName()).log(Level.SEVERE, null, ex);
        }        
            
    }
    public static void main(String[] args) throws FileNotFoundException {
        timetableDAOIMPL ttd=new timetableDAOIMPL();
        ttd.DownloadTimeTable("D:\\Java\\TimeTable-DSS\\src\\main\\java\\beans\\ec\\dss\\Files\\Data");
    }
}
