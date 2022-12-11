package beans.ec.dss.entities;

public class slotassigned 
{
    private String slotno;
    private String courseno;

    public slotassigned(String slotno, String courseno) {
        this.slotno = slotno;
        this.courseno = courseno;
    }

    public String getSlotno() {
        return slotno;
    }

    public void setSlotno(String slotno) {
        this.slotno = slotno;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    @Override
    public String toString() {
        return "slotassigned{" + "slotno=" + slotno + ", courseno=" + courseno + '}';
    }
    
}
