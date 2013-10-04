package Grade.ServiceImpl;

import C.InquiryReturn.InquReturn;
import Grade.InquiryReturn.InquReturn_Gra;
import Grade.dao.GradDao;
import Grade.model.Grade;
import Grade.service.GraServiceDao;
import MyException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 12:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class GraServiceImpl implements GraServiceDao {

    @Autowired
    private GradDao grddao;

    /**
     * Get all students
     *
     * @return
     */
    @Transactional(readOnly = true)
    public InquReturn_Gra inquiry(int id, int start, int limit) throws MyException {

        InquReturn_Gra inqre = null;
        try {
            inqre = grddao.inquiry(id, start, limit);
        } catch (MyException e) {
            throw new MyException("view");
        }
        return inqre;
    }


    @Transactional(readOnly = true)
    public InquReturn_Gra inquirystuname(ArrayList kcms, ArrayList stunames, int start, int limit) throws MyException {

        InquReturn_Gra inqre = null;
        try {
            inqre = grddao.inquirystuname(stunames, kcms, start, limit);
        } catch (MyException e) {
            throw new MyException("viewstunamelist");
        }
        return inqre;
    }

    @Transactional(readOnly = true)
    public InquReturn_Gra inquirycourse(ArrayList kcms, int start, int limit) throws MyException {

        InquReturn_Gra inqre = null;
        try {
            inqre = grddao.inquirycourse(kcms, start, limit);
        } catch (MyException e) {
            throw new MyException("viewcourlist");
        }
        return inqre;
    }


    /**
     * Create new Contact/Contacts
     *
     * @param data - json data from request
     * @return created contacts
     */
    @Transactional
    public void create(List<Grade> data) throws MyException {


        for (Grade contact : data) {
            try {
                grddao.create(contact);
            } catch (MyException e) {

                throw new MyException("add");

            }
        }


    }


    /**
     * Update contact/contacts
     *
     * @param - json data from request
     * @return updated contacts
     */
    @Transactional
    public void update(List<Grade> updatedContacts) throws MyException {


        for (Grade contact : updatedContacts) {
            try {
                grddao.update(contact);

            } catch (MyException e) {

                throw new MyException("update");
            }

        }

    }

    /**
     * Delete contact/contacts
     *
     * @param - json data from request
     */
    @Transactional
    public void delete(List<Grade> list) throws MyException {


        for (Grade contact : list)
            try {

                grddao.delete(contact);
            } catch (MyException e) {

                throw new MyException("delete");
            }
    }


}
