package C.controler;

import C.InquiryBody.ClaInqcondition;
import C.InquiryReturn.InquReturn;
import C.ServiceDao.ClassServiceDao;
import C.ServiceImpl.ClassService;
import C.model.Course;
import C.model.CourseName;
import C.util.ClassUtil;
import MyException.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

public class ClassController {

    @Autowired
    private ClassServiceDao ClassService;

    @Autowired
    private ClassUtil clautil;


    @RequestMapping(value = "/Course/view.action", method = RequestMethod.GET)

    public
    @ResponseBody
    Map<String, ? extends Object> view(@RequestParam String Kch, @RequestParam String Kcm, @RequestParam String start, @RequestParam String limit) throws Exception {
        ClaInqcondition inqcond = new ClaInqcondition();
        try {


            int start1 = Integer.parseInt(start);
            int limit1 = Integer.parseInt(limit);

            inqcond.setKch(clautil.getinqucondFromJSON(Kch).getString("kch"));
            inqcond.setKcm(clautil.getinqucondFromJSON(Kcm).getString("kcm"));

            InquReturn inqe = ClassService.getList(inqcond, start1, limit1);
            return getMap(inqe);

        } catch (MyException e) {
            e.printStackTrace();
            return getModelMapError("Error trying to view contact.", inqcond);

        }
    }


    @RequestMapping(value = "/Course/viewcurname.action", method = RequestMethod.GET)

    public
    @ResponseBody
    Map<String, ? extends Object> viewcurname(@RequestParam Object query) throws Exception {
        List<CourseName> courseList = null;
        try {

            String name = clautil.getStringFromJSON(query,"autoContent");
            courseList = ClassService.getcurnameMap(name);
            return getcurnameMap(courseList);

        } catch (MyException e) {
            e.printStackTrace();
            return getModelMapError("Error trying to view contact.", courseList);

        }
    }


    @RequestMapping(value = "/Course/viewcurnum.action", method = RequestMethod.GET)

    public
    @ResponseBody
    Map<String, ? extends Object> viewcurnum() throws Exception {
        InquReturn courseList = null;
        try {


            courseList = ClassService.getCurNumList();
            return getcomoboxMap(courseList);

        } catch (MyException e) {
            e.printStackTrace();
            return getModelMapError("Error trying to view contact.", courseList);

        }
    }

    @RequestMapping(value = "/Course/create.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> create(@RequestParam Object data) throws Exception {

        try {

            ClassService.create(clautil.getstudentsFromRequest(data));

            return getcondMap();

        } catch (MyException e) {
            e.printStackTrace();

            return getModelMapError("Error trying to create contact.", data);
        }
    }

    @RequestMapping(value = "/Course/update.action")
    public
    @ResponseBody
    Map<String, ? extends Object> update(@RequestParam Object data) throws Exception {
        try {

            ClassService.update(clautil.getstudentsFromRequest(data));

            return getcondMap();

        } catch (MyException e) {

            return getModelMapError("Error trying to update contact.", data);
        }
    }

    @RequestMapping(value = "/Course/delete.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> delete(@RequestParam Object data) throws Exception {

        try {

            ClassService.delete(clautil.getstudentsFromRequest(data));

            Map<String, Object> modelMap = new HashMap<String, Object>(3);
            modelMap.put("success", true);

            return modelMap;

        } catch (MyException e) {

            return getModelMapError("无法删除", data);
        }
    }

    /**
     * Generates modelMap to return in the modelAndView
     *
     * @param contacts
     * @return
     */
    private Map<String, Object> getMap(InquReturn contacts) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", contacts.getCount());
        modelMap.put("data", contacts.getCur());
        modelMap.put("success", true);

        return modelMap;

    }

    private Map<String, Object> getcomoboxMap(InquReturn contacts) {
        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", contacts.getCount());
        modelMap.put("data", contacts.getCurr());
        modelMap.put("success", true);

        return modelMap;


    }

    private Map<String, Object> getcurnameMap(List<CourseName> contacts) {
        Map<String, Object> modelMap = new HashMap<String, Object>(3);

        modelMap.put("data", contacts);


        return modelMap;


    }


    private Map<String, Object> getcondMap() {
        Map<String, Object> modelMap = new HashMap<String, Object>(3);

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


    public void setStudentService(ClassService studentService) {
        this.ClassService = studentService;
    }

}
