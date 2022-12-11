package beans.ec.dss.DAO;

import beans.ec.dss.entities.slotassigned;
import java.util.ArrayList;
import java.util.HashMap;

public interface slotassignedDAO 
{
    public void addSlotAssigned(slotassigned sa);
    public HashMap<String,ArrayList<String>> viewSlotAssigned();
}
