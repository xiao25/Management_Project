package Student.util;

import Student.model.Student;

import java.io.UnsupportedEncodingException;
import java.util.List;

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

    static public Student Stringchage(Student stu) {

        stu.setStuname(UnicodetoUTF.Stringchagen(stu.getStuname()));
        stu.setAddress(UnicodetoUTF.Stringchagen(stu.getAddress()));
        stu.setClassnum(UnicodetoUTF.Stringchagen(stu.getClassnum()));
        stu.setPhone(UnicodetoUTF.Stringchagen(stu.getPhone()));
        stu.setRemark(UnicodetoUTF.Stringchagen(stu.getRemark()));
        return stu;
    }


}
