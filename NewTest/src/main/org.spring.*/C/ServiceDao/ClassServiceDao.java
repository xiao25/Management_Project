package C.ServiceDao;

import C.InquiryBody.ClaInqcondition;
import C.InquiryReturn.InquReturn;
import C.model.Course;
import C.model.CourseName;
import MyException.MyException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/3/13
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ClassServiceDao {
    public InquReturn getList(ClaInqcondition inq, int start, int limit) throws MyException;

    public void create(List<Course> list) throws MyException;

    public void delete(List<Course> list) throws MyException;

    public void update(List<Course> updatedContacts) throws MyException;

    public InquReturn getCurNumList() throws MyException;

    public List<CourseName> getcurnameMap(String name) throws MyException;
}
