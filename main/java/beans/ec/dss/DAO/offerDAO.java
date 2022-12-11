package beans.ec.dss.DAO;

import beans.ec.dss.entities.offer;
import java.util.List;

public interface offerDAO 
{
    public void addOffer(offer off);    
    public List<offer> viewOffer();
}
