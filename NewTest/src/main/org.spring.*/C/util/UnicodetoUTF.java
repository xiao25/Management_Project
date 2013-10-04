package C.util;

import C.model.Course;
import Student.model.Student;

import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 7/3/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class UnicodetoUTF {
    static public String Stringchagen(String data) {
        try {
            byte[] utf8 = data.getBytes("UTF-8");
            return (new String(utf8, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new String("false");
    }

    static public Course Stringchage(Course stu) {

        stu.setId(C.util.UnicodetoUTF.Stringchagen(stu.getId()));

        stu.setKcm(C.util.UnicodetoUTF.Stringchagen(stu.getKcm()));
        stu.setRemarks(C.util.UnicodetoUTF.Stringchagen(stu.getRemarks()));

        return stu;
    }


}
