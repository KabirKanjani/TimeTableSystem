package beans.ec.dss.DAO;

import beans.ec.dss.entities.categories;
import java.sql.SQLException;
import java.util.List;

public interface categoriesDAO 
{
    public void addCategory(categories category);
    public void viewCategory(categories category);    
}
