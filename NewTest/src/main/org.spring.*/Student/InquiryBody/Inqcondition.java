package Student.InquiryBody;

import Student.model.Student;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/27/13
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class Inqcondition {
    private String stuname;
    private String classnum;
    private String stunum;
    private Date birthday1;
    private Date birthday2;

    public Inqcondition(String stuname, String classnum, String stunum, Date birthday1, Date birthday2) {
        this.stuname = stuname;
        this.classnum = classnum;
        this.stunum = stunum;
        this.birthday1 = birthday1;
        this.birthday2 = birthday2;
    }

    public Date getBirthday1() {
        return birthday1;
    }

    public void setBirthday1(Date birthday1) {
        this.birthday1 = birthday1;
    }

    public Date getBirthday2() {
        return birthday2;
    }

    public void setBirthday2(Date birthday2) {
        this.birthday2 = birthday2;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }


    public Inqcondition() {
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
}
