package C.dao;

import C.InquiryBody.ClaInqcondition;
import C.InquiryReturn.InquReturn;
import C.model.Course;
import C.model.CourseName;
import MyException.MyException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/19/13
 * Time: 12:37 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CourDao {

    public void update(Course cur) throws MyException;

    public void add(Course cur) throws MyException;

    public void delete(Course cur) throws MyException;

    public InquReturn inquiry(ClaInqcondition inq, int start, int limit) throws MyException;

    public InquReturn inquirycurnum() throws MyException;

    public List<CourseName> inquirycurname(String name) throws MyException;
}
