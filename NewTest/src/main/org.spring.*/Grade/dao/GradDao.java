package Grade.dao;

import Grade.InquiryReturn.InquReturn_Gra;
import Grade.model.Grade;
import MyException.MyException;

import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/19/13
 * Time: 1:04 AM
 * To change this template use File | Settings | File Templates.
 */
public interface GradDao {
    public void update(Grade grd) throws MyException;

    public void create(Grade grd) throws MyException;

    public void delete(Grade grd) throws MyException;

    public InquReturn_Gra inquirystuname(ArrayList stunames, ArrayList kcms, int start, int limit) throws MyException;

    public InquReturn_Gra inquirycourse(ArrayList kcms, int start, int limit) throws MyException;

    public InquReturn_Gra inquiry(int id, int start, int limit) throws MyException;
}
