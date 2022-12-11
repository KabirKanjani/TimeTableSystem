package beans.ec.dss.DAO;

import beans.ec.dss.entities.programs;
import java.util.List;

public interface programsDAO 
{
    public void addPrograms(programs program);    
    public List<programs> viewPrograms();
}
