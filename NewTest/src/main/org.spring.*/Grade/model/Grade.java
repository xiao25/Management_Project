package Grade.model;


import C.model.Course;
import Student.model.Student;

/**
 * Created with IntelliJ IDEA.
 * User: ztx
 * Date: 6/18/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Grade {
    private int id;
    private int ach;
    private Course course;
    private Student student;
//     private int stuid;
//    private String curid;


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCurid() {
        return course.getId();
    }

    public void setCurid(String curid) {
        this.course = new Course();
        this.course.setId(curid);
    }

    public int getStuid() {
        return student.getId();
    }

    public void setStuid(int id) {
        this.student = new Student();
        this.student.setId(id);
    }

    public Grade() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAch() {
        return ach;
    }

    public void setAch(int ach) {
        this.ach = ach;
    }


}
