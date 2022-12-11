package beans.ec.dss.entities;

public class programs 
{
    private String programid;
    private String programname;
    private int plabel;

    public String getProgramid() {
        return programid;
    }

    public void setProgramid(String programid) {
        this.programid = programid;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public int getPlabel() {
        return plabel;
    }

    public void setPlabel(int plabel) {
        this.plabel = plabel;
    }

    public programs(String programid, String programname, int plabel) {
        this.programid = programid;
        this.programname = programname;
        this.plabel = plabel;
    }

    @Override
    public String toString() {
        return "programs{" + "programid=" + programid + ", programname=" + programname + ", plabel=" + plabel + '}';
    }
    
}
