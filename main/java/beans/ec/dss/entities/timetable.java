package beans.ec.dss.entities;

public class timetable 
{
    private String day;
    private String hour;
    private String slotno;

    public timetable(String day, String hour, String slotno) {
        this.day = day;
        this.hour = hour;
        this.slotno = slotno;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getSlotno() {
        return slotno;
    }

    public void setSlotno(String slotno) {
        this.slotno = slotno;
    }

    @Override
    public String toString() {
        return "timetable{" + "day=" + day + ", hour=" + hour + ", slotno=" + slotno + '}';
    }
    
    
    
}
