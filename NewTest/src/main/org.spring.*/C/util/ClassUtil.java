package C.util;

import C.model.Course;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.stereotype.Component;
import C.InquiryBody.ClaInqcondition;

import java.util.ArrayList;
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
public class ClassUtil {

    /**
     * Get list of Students from request.
     *
     * @param data - json data from request
     * @return list of students
     */
    public List<Course> getstudentsFromRequest(Object data) {

        List<Course> list;

        //it is an array - have to cast to array object
        if (data.toString().indexOf('[') > -1) {

            list = getListstudentFromJSON(data);
            List<Course> newcur = new ArrayList<Course>();
            for (Course cur : list) {
                cur = UnicodetoUTF.Stringchage(cur);
                newcur.add(cur);
            }

        } else { //it is only one object - cast to object/bean

            Course student = getstudentFromJSON(data);

            list = new ArrayList<Course>();
            student = UnicodetoUTF.Stringchage(student);


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
    private Course getstudentFromJSON(Object data) {
        JSONObject jsonObject = JSONObject.fromObject(data);

        Course student = (Course) JSONObject.toBean(jsonObject, Course.class);
        return student;
    }

    /**
     * Transform json data format into list of Contact objects
     *
     * @param data - json data from request
     * @return
     */
    @SuppressWarnings("unchecked")
    private List<Course> getListstudentFromJSON(Object data) {
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Course> newstudents = (List<Course>) JSONArray.toList(jsonArray, Course.class);
        return newstudents;
    }

    /**
     * Tranform array of string in json data format into
     * list of Integer
     *
     * @param data - json data from request
     * @return
     */
    @SuppressWarnings("unchecked")
    public String getStringFromJSON(Object data,String key) {
         if(!data.equals(""))
        return JSONObject.fromObject(data).getString(key);
        else
             return data.toString();
    }

    public JSONObject getinqucondFromJSON(Object data) {
        JSONObject jsonObject = JSONObject.fromObject(data);


        return jsonObject;
    }


}
