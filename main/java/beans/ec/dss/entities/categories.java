package beans.ec.dss.entities;

public class categories 
{
    private int categoryid;
    private String categoryname;

    public categories(int categoryid, String categoryname) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
    }
    public categories(String categoryname)
    {
        this.categoryname=categoryname;        
    }

    public categories(int id) {
        this.categoryid=id;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "categories{" + "categoryid=" + categoryid + ", categoryname=" + categoryname + '}';
    }
    
    
}
