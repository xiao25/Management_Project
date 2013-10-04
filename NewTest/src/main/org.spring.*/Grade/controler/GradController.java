package Grade.controler;

import Grade.InquiryReturn.InquReturn_Gra;
import Grade.model.CourseGrade;
import Grade.model.GridData;
import Grade.service.GraServiceDao;
import Grade.util.GradUtil;
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
 * Date: 7/9/13
 * Time: 9:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class GradController {
    @Autowired
    private GraServiceDao grdservice;

    @Autowired
    private GradUtil grdutil;


    @RequestMapping(value = "/Grade/view.action", method = RequestMethod.GET)

    public
    @ResponseBody
    Map<String, ? extends Object> view(@RequestParam int id, @RequestParam String start, @RequestParam String limit) throws Exception {

        try {
            InquReturn_Gra inqe = null;

            int start1 = Integer.parseInt(start);
            int limit1 = Integer.parseInt(limit);
            inqe = grdservice.inquiry(id, start1, limit1);
            return getMap(inqe);

        } catch (MyException e) {

            return getModelMapError("Error trying to view contact.", id);

        }
    }


    @RequestMapping(value = "/Grade/viewsbycur.action", method = RequestMethod.GET)

    public
    @ResponseBody
    Map<String, ? extends Object> viewbycur(@RequestParam Object kcm, @RequestParam String start, @RequestParam String limit) throws Exception {
        InquReturn_Gra courseList = null;
        try {

            int start1 = Integer.parseInt(start);
            int limit1 = Integer.parseInt(limit);
            ArrayList kcms = grdutil.getstuidFromRequest(kcm);
            courseList = grdservice.inquirycourse(kcms, start1, limit1);
            return getGriddMap(courseList);

        } catch (MyException e) {

            return getModelMapError("Error trying to view contact.", kcm);

        }
    }


    @RequestMapping(value = "/Grade/viewsbystu.action", method = RequestMethod.POST)

    public
    @ResponseBody
    Map<String, ? extends Object> viewbystu(@RequestParam Object kcm, @RequestParam Object stuname, @RequestParam String start, @RequestParam String limit) throws Exception {
        InquReturn_Gra courseList = null;
        //  try {

        int start1 = Integer.parseInt(start);
        int limit1 = Integer.parseInt(limit);
        ArrayList stunames = grdutil.getstuidFromRequest(stuname);
        ArrayList kcms = grdutil.getstuidFromRequest(kcm);

        courseList = grdservice.inquirystuname(kcms, stunames, start1, limit1);
        return getGridMap(courseList, kcms, stunames);


//        } catch (MyException e) {
//
//            return getModelMapError("Error trying to view contact.",kcm);
//
//        }
    }

    @RequestMapping(value = "/Grade/create.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> create(@RequestParam Object data) throws Exception {

        try {

            grdservice.create(grdutil.getstudentsFromRequest(data));

            return getcondMap();

        } catch (MyException e) {


            return getModelMapError("Error trying to create contact.", data);
        }
    }

    @RequestMapping(value = "/Grade/update.action")
    public
    @ResponseBody
    Map<String, ? extends Object> update(@RequestParam Object data) throws Exception {
        try {

            grdservice.update(grdutil.getstudentsFromRequest(data));

            return getcondMap();

        } catch (MyException e) {

            return getModelMapError("Error trying to update contact.", data);
        }
    }

    @RequestMapping(value = "/Grade/delete.action", method = RequestMethod.POST)
    public
    @ResponseBody
    Map<String, ? extends Object> delete(@RequestParam Object data) throws Exception {

        try {

            grdservice.delete(grdutil.getstudentsFromRequest(data));

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
    private Map<String, Object> getMap(InquReturn_Gra contacts) {

        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        modelMap.put("total", contacts.getCount());
        modelMap.put("data", contacts.getGrd());
        modelMap.put("success", true);

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


    private Map<String, Object> getGriddMap(InquReturn_Gra contacts) {
        Map<String, Object> modelMap = new HashMap<String, Object>(2);
        List<CourseGrade> courgrd = new ArrayList<CourseGrade>();
        for (int i = 0; i < contacts.getGrd().size(); i++) {
            CourseGrade newcg = new CourseGrade();
            newcg.setStuname(contacts.getGrd().get(i).getStudent().getStuname());
            newcg.setStuid(contacts.getGrd().get(i).getStuid());
            newcg.setClassnum(contacts.getGrd().get(i).getStudent().getClassnum());
            newcg.setGrade(contacts.getGrd().get(i).getAch());
            courgrd.add(newcg);
        }
        modelMap.put("data", courgrd);
        modelMap.put("total", contacts.getCount());
        modelMap.put("success", true);
        return modelMap;
    }

    private Map<String, Object> getGridMap(InquReturn_Gra contacts, ArrayList kcms, ArrayList stunames) {

        Map<String, Object> modelMap = new HashMap<String, Object>(2);


        List<GridData> stugrds = new ArrayList<GridData>();


        for (int i = 0; i < contacts.getGrd().size(); i++) {
            int j = 0;
            int stuid = contacts.getGrd().get(i).getStudent().getId();
            for (; j < stugrds.size(); j++) {
                if (stuid == stugrds.get(j).getStuid()) {
                    for (int z = 0; z < kcms.size(); z++) {

                        if (kcms.get(z).equals(contacts.getGrd().get(i).getCourse().getKcm())) {
                            stugrds.get(j).getCoursegrade().set(z, Integer.toString(contacts.getGrd().get(i).getAch()));

                            int total = stugrds.get(j).getTotal();
                            total += contacts.getGrd().get(i).getAch();
                            stugrds.get(j).setTotal(total);
                            break;
                        }
                    }
                    break;
                }
            }
            if (j == stugrds.size()) {
                GridData griddata = new GridData();
                griddata.setStuname(contacts.getGrd().get(i).getStudent().getStuname());
                griddata.setStuid(stuid);
                ArrayList<String> grds = new ArrayList();
                for (int z = 0; z < kcms.size(); z++) {
                    String a = new String();
                    grds.add(a);
                    if (kcms.get(z).equals(contacts.getGrd().get(i).getCourse().getKcm())) {
                        grds.set(z, Integer.toString(contacts.getGrd().get(i).getAch()));
                        int total = contacts.getGrd().get(i).getAch();
                        griddata.setTotal(total);

                    }
                }
                griddata.setCoursegrade(grds);
                stugrds.add(griddata);


            }


        }

        modelMap.put("data", stugrds);
        modelMap.put("kcms", kcms);
        modelMap.put("success", true);
        modelMap.put("total", stugrds.size());
        return modelMap;
    }


}

