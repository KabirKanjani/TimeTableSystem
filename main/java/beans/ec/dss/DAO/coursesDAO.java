package beans.ec.dss.DAO;

import beans.ec.dss.entities.courses;
import java.util.List;

public interface coursesDAO 
{
    public void AddCourse(courses course);
    public List<courses> viewCourse();    
}
