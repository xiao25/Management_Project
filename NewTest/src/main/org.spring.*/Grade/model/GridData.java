package Grade.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/12/13
 * Time: 2:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class GridData {
    private int stuid;
    private String stuname;
    private ArrayList<String> coursegrade;
    private int total;
    private int rank;

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public ArrayList getCoursegrade() {
        return coursegrade;
    }

    public void setCoursegrade(ArrayList coursegrade) {
        this.coursegrade = coursegrade;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
