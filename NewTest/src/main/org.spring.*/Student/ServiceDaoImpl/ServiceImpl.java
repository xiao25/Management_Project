package Student.ServiceDaoImpl;

import MyException.MyException;
import Student.InquiryBody.Inqcondition;
import Student.InquiryReturn.InquiryReturn;
import Student.InquiryReturn.Stuname_Stuid;
import Student.ServiceDao.StudentService;
import Student.model.Student;
import Student.model.name_id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Student.dao.StuDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/23/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ServiceImpl implements StudentService {


    @Autowired
    private StuDao studao;

    /**
     * Get all students
     *
     * @return
     */
    @Transactional(readOnly = true)
    public InquiryReturn getList(Inqcondition inq, int start, int limit) throws MyException {
        InquiryReturn inquiryReturn = null;
        try {
            inquiryReturn = studao.inquiry(inq, start, limit);
        } catch (MyException e) {
            e.printStackTrace();
            throw new MyException("inquiey");

        }
        return inquiryReturn;
    }

    /**
     * Create new Contact/Contacts
     *
     * @param list
     * @return created contacts
     */
    @Transactional
    public void create(List<Student> list) throws MyException {


        for (Student contact : list) {
            try {
                studao.add(contact);
            } catch (MyException e) {
                e.printStackTrace();
                throw new MyException("add");

            }
        }


    }


    /**
     * Update contact/contacts
     *
     * @param updatedContacts - json data from request
     * @return updated contacts
     */
    @Transactional
    public void update(List<Student> updatedContacts) throws MyException {


        for (Student contact : updatedContacts) {
            try {


                studao.update(contact);
            } catch (MyException e) {
                e.printStackTrace();
                throw new MyException("update");

            }
        }


    }

    /**
     * Delete contact/contacts
     *
     * @param deleteContacts
     */
    @Transactional
    public void delete(List<Student> deleteContacts) throws MyException {


        for (Student contact : deleteContacts) {

            try {

                studao.delete(contact.getId());
            } catch (MyException e) {
                e.printStackTrace();
                throw new MyException("delete");

            }

        }
    }


    @Transactional
    public List<name_id> getidnames(String name) throws MyException {
        List<name_id> stuid = null;
        try {
            stuid = studao.viewidnames(name);
        } catch (MyException e) {
            e.printStackTrace();
            throw new MyException("viewstunames");

        }
        return stuid;
    }

    public void setStudao(StuDao studao) {
        this.studao = studao;
    }


}