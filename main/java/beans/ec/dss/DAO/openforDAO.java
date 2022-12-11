package beans.ec.dss.DAO;

import beans.ec.dss.entities.openfor;
import java.util.List;

public interface openforDAO 
{
    public void addOpenFor(openfor openf);
    public List<openfor> viewOpenFor();
}
