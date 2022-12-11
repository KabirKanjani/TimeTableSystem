package beans.ec.dss.entities;

public class courses 
{
    private String courseno;
    private String coursename;
    private String credit;
    private Float credit_lec;
    private Float credit_tutorial;
    private Float credit_lab;
    private Float credit_total;

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getCoursename() {
        return coursename;
    }

    public courses(String courseno, String coursename, String credit, Float credit_lec, Float credit_tutorial, Float credit_lab, Float credit_total) {        
        this.courseno = courseno;
        this.coursename = coursename;
        this.credit = credit;
        this.credit_lec = credit_lec;
        this.credit_tutorial = credit_tutorial;
        this.credit_lab = credit_lab;
        this.credit_total = credit_total;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public Float getCredit_lec() {
        return credit_lec;
    }

    public void setCredit_lec(Float credit_lec) {
        this.credit_lec = credit_lec;
    }

    public Float getCredit_tutorial() {
        return credit_tutorial;
    }

    public void setCredit_tutorial(Float credit_tutorial) {
        this.credit_tutorial = credit_tutorial;
    }

    public Float getCredit_lab() {
        return credit_lab;
    }

    public void setCredit_lab(Float credit_lab) {
        this.credit_lab = credit_lab;
    }

    public Float getCredit_total() {
        return credit_total;
    }

    public void setCredit_total(Float credit_total) {
        this.credit_total = credit_total;
    }


    @Override
    public String toString() {
        return "courses{" + "courseno=" + courseno + ", coursename=" + coursename + ", credit=" + credit + ", credit_lec=" + credit_lec + ", credit_tutorial=" + credit_tutorial + ", credit_lab=" + credit_lab + ", credit_total=" + credit_total + '}';
    }
    
    
    
}
