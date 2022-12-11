package beans.ec.dss.entities;

public class facultyassigned 
{
    private String courseno;
    private String shortname;
    private String section;

    public facultyassigned(String courseno, String shortname, String section) {
        this.courseno = courseno;
        this.shortname = shortname;
        this.section = section;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "facultyassigned{" + "courseno=" + courseno + ", shortname=" + shortname + ", section=" + section + '}';
    }
    
    
    
}
