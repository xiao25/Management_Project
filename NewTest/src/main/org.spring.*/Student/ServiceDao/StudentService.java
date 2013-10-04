package Student.ServiceDao;

import MyException.MyException;
import Student.InquiryBody.Inqcondition;
import Student.InquiryReturn.InquiryReturn;
import Student.InquiryReturn.Stuname_Stuid;
import Student.model.Student;
import Student.model.name_id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/29/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
//服务层接口
public interface StudentService {
    public InquiryReturn getList(Inqcondition inq, int start, int limit) throws MyException;

    public List<name_id> getidnames(String name) throws MyException;

    public void create(List<Student> list) throws MyException;

    public void delete(List<Student> list) throws MyException;

    public void update(List<Student> updatedContacts) throws MyException;


}
