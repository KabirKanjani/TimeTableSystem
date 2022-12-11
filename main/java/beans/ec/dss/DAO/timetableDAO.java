package beans.ec.dss.DAO;

import beans.ec.dss.entities.timetable;

public interface timetableDAO 
{
    public void addTimeTable(timetable tt);
    public String[][] viewTimeTable();
}
