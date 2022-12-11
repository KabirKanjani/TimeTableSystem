package beans.ec.dss.entities;

public class roomassigned 
{
    private String roomno;
    private String courseno;
    private char section;

    public roomassigned(String roomno, String courseno, char section) {
        this.roomno = roomno;
        this.courseno = courseno;
        this.section = section;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "roomassigned{" + "roomno=" + roomno + ", courseno=" + courseno + ", section=" + section + '}';
    }
    
    
}
