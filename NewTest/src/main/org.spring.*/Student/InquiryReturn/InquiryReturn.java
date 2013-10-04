package Student.InquiryReturn;

import Student.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/2/13
 * Time: 12:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class InquiryReturn {
    private List<Student> stud;
    private int count;

    public InquiryReturn() {
    }

    public List<Student> getStud() {
        return stud;
    }

    public void setStud(List<Student> stud) {
        this.stud = stud;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
