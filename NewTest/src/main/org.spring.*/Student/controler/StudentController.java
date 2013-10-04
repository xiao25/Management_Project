package Student.controler;

import MyException.MyException;
import Student.InquiryBody.Inqcondition;
import Student.InquiryReturn.InquiryReturn;
import Student.InquiryReturn.Stuname_Stuid;
import Student.ServiceDao.StudentService;
import Student.model.Student;
import Student.model.name_id;
import Student.util.StuUtil;
import Student.util.UnicodetoUTF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import Student.ServiceDaoImpl.ServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/23/13
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller

public class StudentController {

    @Autowired
    private StudentService studentService;
    //json->java data object
    @Autowired
    private StuUtil util;

    @RequestMapping(value = "/student/view.action", method = RequestMethod.GET)
     /*
     根据学生姓名与班机信息进行查询，返回符合条件的学生集合
     * */
    public
    @ResponseBody
    Map<String, ? extends Object> view(@RequestParam Object data, @RequestParam String start, @RequestParam String limit) throws Exception {
        InquiryReturn inqreturn;


        Inqcondition inqcond = util.getInqCond(data);
        try {


            int start1 = Integer.parseInt(start);
            int limit1 = Integer.parseInt(limit);

            if(inqcond.getStuname()!=null)
            inqcond.setStuname(UnicodetoUTF.Stringchagen(inqcond.getStuname()));

            inqreturn = studentService.getList(inqcond, start1, limit1);

            return getMapinq(inqreturn);

        } catch (MyException e) {
            System.out.println(e.getMessage());
            return getModelMapError("Error retrieving Contacts from database.", inqcond);
        }
    }

    @RequestMapping(value = "/Student/viewstuname.action", method = RequestMethod.GET)
     /*
     查询出当前所有学生学号
     * */
    public
    @ResponseBody
    Map<String, ? extends Object> viewstuname(@RequestParam Object query) throws Exception {
        List<name_id> id_name = null;
        try {

            String name = util.getStringFromJSON(query,"autoContent");
            id_name = studentService.getidnames(name);
            return getstuidsMap(id_name);

        } catch (MyException e) {
            System.out.println(e.getMessage());
            return getModelMapError("Error retrieving Contacts from database.", null);
        }
    }


    /*
    添加一个学生信息
    * */
    @RequestMapping(value = "/student/create.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> create(@RequestParam Object data) throws Exception {

        try {
            List<Student> stu = util.getstudentsFromRequest(data);


            studentService.create(stu);

            return getcreateMap();

        } catch (MyException e) {

            return getModelMapError("Error trying to create contact.", data);
        }
    }

    /*
   更新同学信息
    * */
    @RequestMapping(value = "/student/update.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> update(@RequestParam Object data) throws Exception {
        try {
            List<Student> stu = util.getstudentsFromRequest(data);
            List<Student> newstu = new ArrayList<Student>();
            for (Student stuu : stu)
                newstu.add(UnicodetoUTF.Stringchage(stuu));
            studentService.update(newstu);

            return getcreateMap();

        } catch (MyException e) {

            return getModelMapError("Error trying to update contact.", data);
        }
    }

    /*
    删除学生信息
    * */
    @RequestMapping(value = "/student/delete.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> delete(@RequestParam Object data) throws Exception {

        try {
            List<Student> stu = util.getstudentsFromRequest(data);
            List<Student> newstu = new ArrayList<Student>();
            for (Student stuu : stu)
                newstu.add(UnicodetoUTF.Stringchage(stuu));
            studentService.delete(newstu);


            return getcreateMap();

        } catch (MyException e) {

            return getModelMapError("无法删除", data);
        }
    }

    /**
     * Generates modelMap to return in the modelAndView
     *
     * @param
     * @return
     */


    private Map<String, Object> getcreateMap() {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);

        modelMap.put("success", true);

        return modelMap;
    }

    private Map<String, Object> getMapinq(InquiryReturn contacts) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", contacts.getCount());
        modelMap.put("data", contacts.getStud());
        modelMap.put("success", true);

        return modelMap;
    }

    /**
     * Generates modelMap to return in the modelAndView in case
     * of exception
     *
     * @param msg message
     * @return
     */
    private Map<String, Object> getModelMapError(String msg, Object data) {

        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        modelMap.put("message", msg);
        modelMap.put("success", false);
        modelMap.put("data", data);
        return modelMap;
    }


    private Map<String, Object> getstuidsMap(List<name_id> id_name) {


        Map<String, Object> newMap = new HashMap<String, Object>(2);
        newMap.put("data", id_name);
        return newMap;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setUtil(StuUtil util) {
        this.util = util;
    }

}
