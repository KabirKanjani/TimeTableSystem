package beans.ec.dss.DAO;

import beans.ec.dss.entities.faculty;
import java.util.List;

public interface facultyDAO 
{
    public void addFaculty(faculty fac);
    public List<faculty> viewFaculty();
}
