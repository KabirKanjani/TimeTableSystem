package beans.ec.dss.entities;

public class coursetype 
{
    private int programid;
    private String courseno;    
    private int categoryid;//Foregin Key for Category

    public coursetype(int programid, String courseno, int categoryid) {
        this.programid = programid;
        this.courseno = courseno;
        this.categoryid = categoryid;
    }

    public int getProgramid() {
        return programid;
    }

    public void setProgramid(int programid) {
        this.programid = programid;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String toString() {
        return "coursetype{" + "programid=" + programid + ", courseno=" + courseno + ", categoryid=" + categoryid + '}';
    }

    
    
}
