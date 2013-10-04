package Student.util;

import Student.InquiryBody.Inqcondition;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.util.JSONUtils;
import Student.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Util class. Contains some common methods that can be used
 * for any class
 *
 * @author Loiane Groner
 *         http://loianegroner.com (English)
 *         http://loiane.com (Portuguese)
 */
@Component
public class StuUtil {

    /**
     * Get list of Students from request.
     *
     * @param data - json data from request
     * @return list of students
     */
    public List<Student> getstudentsFromRequest(Object data) {

        List<Student> list;

        //it is an array - have to cast to array object
        if (data.toString().indexOf('[') > -1) {

            list = getListstudentFromJSON(data);
            List<Student> newstu = new ArrayList<Student>();

            for (Student stu : list) {
                stu = UnicodetoUTF.Stringchage(stu);
                newstu.add(stu);
            }

        } else { //it is only one object - cast to object/bean

            Student student = getstudentFromJSON(data);
            student = UnicodetoUTF.Stringchage(student);
            list = new ArrayList<Student>();
            list.add(student);
        }

        return list;
    }

    /**
     * Transform json data format into student object
     *
     * @param data - json data from request
     * @return
     */
    private Student getstudentFromJSON(Object data) {
        String[] dateformates = new String[]{"yyyy-MM-dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateformates));
        JSONObject jsonObject = JSONObject.fromObject(data);
        if (jsonObject.getString("id") == "null") {
            jsonObject.remove("id");
            jsonObject.put("id", 0);
        }

        Student student = (Student) JSONObject.toBean(jsonObject, Student.class);
        return student;
    }


    public Inqcondition getInqCond(Object data) {
        String[] dateformates1 = new String[]{"yyyy-MM-dd"};
        String[] dateformates2 = new String[]{"yyyy-MM-dd"};
//        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateformates1));
//        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateformates2));
        JSONObject jsonObject = JSONObject.fromObject(data);
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
         Date birthday1=null;
          Date birthday2=null;
        if(!jsonObject.getString("birthday1").equals("")){
            try{
                birthday1=format.parse(jsonObject.getString("birthday1"));

            }
            catch (Exception e){
                e.printStackTrace();

            }

        }
        if(!jsonObject.getString("birthday2").equals("")){
            try{
                birthday2=format.parse(jsonObject.getString("birthday2"));

            }
            catch (Exception e){
                e.printStackTrace();

            }

        }
        String stuname=null;
        if(jsonObject.size()==5) {
         stuname=jsonObject.getString("stuname");
        }

        Inqcondition student = new Inqcondition(stuname,jsonObject.getString("classnum"),jsonObject.getString("stunum"),birthday1,birthday2);
        return student;
    }

    /**
     * Transform json data format into list of Contact objects
     *
     * @param data - json data from request
     * @return
     */

    private List<Student> getListstudentFromJSON(Object data) {
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Student> newstudents = (List<Student>) JSONArray.toList(jsonArray, Student.class);
        return newstudents;
    }

    public String getStringFromJSON(Object data, String key) {

        return JSONObject.fromObject(data).getString(key);
    }




}
