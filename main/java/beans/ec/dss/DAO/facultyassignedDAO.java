package beans.ec.dss.DAO;

import beans.ec.dss.entities.facultyassigned;
import java.util.List;

public interface facultyassignedDAO 
{
    public void addFacultyAssigned(facultyassigned facA);
    public List<facultyassigned> viewFacultyAssigned();
}
