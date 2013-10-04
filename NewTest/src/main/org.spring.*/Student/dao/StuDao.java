package Student.dao;

import java.util.ArrayList;
import java.util.List;

import MyException.MyException;
import Student.InquiryBody.Inqcondition;
import Student.InquiryReturn.InquiryReturn;
import Student.InquiryReturn.Stuname_Stuid;
import Student.model.Student;
import Student.model.name_id;

/**
 * Created with IntelliJ IDEA.
 * User: ghost
 * Date: 13-6-17
 * Time: �??8:47
 * To change this template use File | Settings | File Templates.
 */
//与数据库交互的学生增删改查操作接口
public interface StuDao {


    public void update(Student stu) throws MyException;

    public void add(Student stu) throws MyException;

    public void delete(int id) throws MyException;

    public InquiryReturn inquiry(Inqcondition inqcond, int start, int limit) throws MyException;

    public List<name_id> viewidnames(String name) throws MyException;


}