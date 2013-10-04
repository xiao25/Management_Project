package Grade.util;

import C.model.Course;
import Grade.model.Grade;

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

    static public Grade Stringchage(Grade stu) {


        return stu;
    }


}
