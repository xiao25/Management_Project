//import Dao.CourDao;
//import Dao.GradDao;
//import student.dao.StuDao;
//import classes.course;
//import classes.grade;
//import student.model.student;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
//* Created with IntelliJ IDEA.
//* User: ghost
//* Date: 13-6-17
//* Time: 下午8:49
//* To change this template use File | Settings | File Templates.
//*/
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-config.xml")
//public class DaoTest {
//    @Autowired
//    private GradDao test_grd_dao;
//
//    @Autowired
//    private StuDao test_stu_dao;
//
//    @Autowired
//    private CourDao test_cur_dao;
//
//
//    student student = new student();
//    course course = new course();
//
//    @Test
//    public void stu_operationTest() {
//
//        //student.setId(0);
//        student.setName("ztx1");
//        student.setAdr("qhhy");
//        student.setClassname("#one");
//        SimpleDateFormat format = new SimpleDateFormat("yyy-mm-dd");
//        String strdate="12/12/07";
//        Date date = null;
//        try {
//            date = format.parse(strdate);
//        } catch (ParseException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//        student.setBir(date);
//        student.setSex(0);
//        student.setRemarks("good");
//
//
//        test_stu_dao.add(student);
//        test_stu_dao.inquiry("ztx1");
//
//
//        student.setName("ztx11");
//        test_stu_dao.add(student);
//        student.setName("ztx22");
//        test_stu_dao.update(student);
//        test_stu_dao.inquiry("ztx22");
//
//    }
//
//    @Test
//    public void cour_operationTest() {
//
//        course.setKch("0001");
//        course.setRemarks("easy to learn");
//        course.setKcm("welldone");
//        course.setAch(000);
//        test_cur_dao.add(course);
//        test_cur_dao.inquiry("0003");
//        course.setAch(001);
//        test_cur_dao.update(course);
//        test_cur_dao.delete("0001");
//    }
//
//
//    @Test
//    public void gra_operationTest() {
//        student.setName("ztx1");
//        student.setAdr("qhhy");
//        student.setClassname("#one");
//
//        student.setSex(0);
//        student.setRemarks("good");
//
//
//        course.setKch("0012");
//        course.setRemarks("easy to learn");
//        course.setKcm("welldone");
//        course.setAch(000);
//        SimpleDateFormat format = new SimpleDateFormat("yyy-mm-dd");
//        String strdate="12/12/07";
//        Date date = null;
//        try {
//            date = format.parse(strdate);
//        } catch (ParseException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
//
//        student.setBir(date);
//        test_stu_dao.add(student);
//        test_cur_dao.add(course);
//        grade grd = new grade();
//        grd.setAch(98);
//        grd.setStudent(student);
//        grd.setCourse(course);
//        test_grd_dao.add(grd);
//        test_grd_dao.inquiry(student, course);
//        grd.setAch(20);
//        //test_grd_dao.delete("0001",5);
//        //test_stu_dao.delete("ztx1");
//
//    }
//
//}
