package C.ServiceImpl;

import C.InquiryReturn.InquReturn;
import C.ServiceDao.ClassServiceDao;
import C.dao.CourDao;

import C.InquiryBody.ClaInqcondition;
import C.model.Course;
import C.model.CourseName;
import MyException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/23/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ClassService implements ClassServiceDao {


    @Autowired
    private CourDao courdao;

    /**
     * Get all students
     *
     * @return
     */
    @Transactional(readOnly = true)
    public InquReturn getList(ClaInqcondition inq, int start, int limit) {

        InquReturn inqre = null;
        try {
            inqre = courdao.inquiry(inq, start, limit);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return inqre;
    }


    @Transactional(readOnly = true)
    public InquReturn getCurNumList() throws MyException {

        InquReturn inqre = null;
        try {
            inqre = courdao.inquirycurnum();
        } catch (MyException e) {
            throw new MyException("getcurlist");
        }
        return inqre;
    }


    @Transactional(readOnly = true)
    public List<CourseName> getcurnameMap(String name) throws MyException {
        List<CourseName> inqre = null;
        try {
            inqre = courdao.inquirycurname(name);
        } catch (MyException e) {
            throw new MyException("getcurlist");
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
    public void create(List<Course> data) throws MyException {


        for (Course contact : data) {
            try {
                courdao.add(contact);
            } catch (MyException e) {
                e.printStackTrace();
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
    public void update(List<Course> updatedContacts) throws MyException {


        for (Course contact : updatedContacts) {
            try {
                courdao.update(contact);

            } catch (MyException e) {
                e.printStackTrace();
                throw new MyException("add");
            }

        }

    }

    /**
     * Delete contact/contacts
     *
     * @param - json data from request
     */
    @Transactional
    public void delete(List<Course> list) throws MyException {


        for (Course contact : list)
            try {

                courdao.delete(contact);
            } catch (MyException e) {
                e.printStackTrace();
                throw new MyException("add");
            }
    }


}