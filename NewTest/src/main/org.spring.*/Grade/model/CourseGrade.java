package Grade.model;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/13/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class CourseGrade {
    private int stuid;
    private String stuname;
    private String classnum;
    private int grade;
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

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
