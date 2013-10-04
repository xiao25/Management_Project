package C.model;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/18/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Course {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    private String id;
    private String kcm;
    private int ach;
    private String remarks;


    public String getKcm() {
        return kcm;
    }

    public void setKcm(String kcm) {
        this.kcm = kcm;
    }

    public int getAch() {
        return ach;
    }

    public void setAch(int ach) {
        this.ach = ach;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
