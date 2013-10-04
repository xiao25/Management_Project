package C.InquiryReturn;

import C.model.Course;
import C.model.CourseNum;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/3/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class InquReturn {
    private List<Course> cur;
    private int count;

    public InquReturn(List<Course> cur, int count) {
        this.cur = cur;
        this.count = count;
    }

    public InquReturn() {
    }

    public List<Course> getCur() {
        return cur;
    }

    public void setCur(List<Course> cur) {
        this.cur = cur;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CourseNum> getCurr() {
        return curr;
    }

    public void setCurr(List<CourseNum> curr) {
        this.curr = curr;
    }

    private List<CourseNum> curr;
}
