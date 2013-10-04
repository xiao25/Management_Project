package Grade.service;

import Grade.InquiryReturn.InquReturn_Gra;
import Grade.model.Grade;
import MyException.MyException;
import Student.InquiryReturn.InquiryReturn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 12:27 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GraServiceDao {
    public void update(List<Grade> stu) throws MyException;

    public void create(List<Grade> stu) throws MyException;

    public void delete(List<Grade> stu) throws MyException;

    public InquReturn_Gra inquiry(int id, int start, int limit) throws MyException;

    public InquReturn_Gra inquirystuname(ArrayList stunames, ArrayList kcms, int start, int limit) throws MyException;

    public InquReturn_Gra inquirycourse(ArrayList kcms, int start, int limit) throws MyException;
}
