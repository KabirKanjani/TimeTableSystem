package beans.ec.dss.entities;

public class faculty 
{
    private String shortname;
    private String fullname;
    private String visitingfaculty;

    public faculty(String shortname, String fullname, String visitingfaculty) {
        this.shortname = shortname;
        this.fullname = fullname;
        this.visitingfaculty = visitingfaculty;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getVisitingfaculty() {
        return visitingfaculty;
    }

     public void setVisitingfaculty(String visitingfaculty) {
        this.visitingfaculty = visitingfaculty;
    }
    
    
}
