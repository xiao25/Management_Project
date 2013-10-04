package Grade.util;

import Grade.InquriyModel.Stu_CurInq;
import Grade.model.Grade;
import Student.model.Student;
import Student.util.*;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/9/13
 * Time: 9:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class GradUtil {

    /**
     * Get list of Students from request.
     *
     * @param data - json data from request
     * @return list of students
     */
    public List<Grade> getstudentsFromRequest(Object data) {

        List<Grade> list;

        //it is an array - have to cast to array object
        if (data.toString().indexOf('[') > -1) {

            list = getListstudentFromJSON(data);


        } else { //it is only one object - cast to object/bean

            Grade student = getstudentFromJSON(data);
//            student= UnicodetoUTF.Stringchage(student);
            list = new ArrayList<Grade>();
            list.add(student);
        }

        return list;
    }

    public ArrayList getstuidFromRequest(Object data) {

        ArrayList list = null;

        //it is an array - have to cast to array object
        if (data.toString().indexOf('[') > -1) {

            JSONArray jsonArray = JSONArray.fromObject(data);

            list = (ArrayList) JSONArray.toList(jsonArray, ArrayList.class);


        } else { //it is only one object - cast to object/bean


            JSONObject jsonObject = JSONObject.fromObject(data);

            String student = jsonObject.getString("kcm");

            list = new ArrayList();
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
    private Grade getstudentFromJSON(Object data) {

        JSONObject jsonObject = JSONObject.fromObject(data);
        if (jsonObject.getString("id") == "null") {
            jsonObject.remove("id");
            jsonObject.put("id", 0);
        }

        Grade student = new Grade();
        student.setStudent(new Student());
        student = (Grade) JSONObject.toBean(jsonObject, Grade.class);
        return student;
    }

    /**
     * Transform json data format into list of Contact objects
     *
     * @param data - json data from request
     * @return
     */

    private List<Grade> getListstudentFromJSON(Object data) {
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Grade> newstudents = (List<Grade>) JSONArray.toList(jsonArray, Grade.class);
        return newstudents;
    }

    /**
     * Tranform array of string in json data format into
     * list of Integer
     *
     * @param data - json data from request
     * @return
     */
}
