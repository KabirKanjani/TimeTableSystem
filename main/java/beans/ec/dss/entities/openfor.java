package beans.ec.dss.entities;

public class openfor 
{
 private String courseno;
 private int programid;
 private int semester;
 private char term;

    public openfor(String courseno, int programid, int semester, char term) {
        this.courseno = courseno;
        this.programid = programid;
        this.semester = semester;
        this.term = term;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public int getProgramid() {
        return programid;
    }

    public void setProgramid(int programid) {
        this.programid = programid;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public char getTerm() {
        return term;
    }

    public void setTerm(char term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "openfor{" + "courseno=" + courseno + ", programid=" + programid + ", semester=" + semester + ", term=" + term + '}';
    }
 
}
