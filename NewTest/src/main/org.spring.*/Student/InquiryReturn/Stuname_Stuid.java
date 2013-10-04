package Student.InquiryReturn;

import Student.model.name_id;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/10/13
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stuname_Stuid {
    private List<name_id> stud;
    private int count;

    public List<name_id> getStud() {
        return stud;
    }

    public void setStud(List<name_id> stud) {
        this.stud = stud;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
