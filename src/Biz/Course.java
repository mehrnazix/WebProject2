package Biz;

import java.sql.SQLException;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Course {

    public Course() {
    }

    public Course(int courseId, String name, int code, int coefficient, int teacherId) {

        this.setCourseId(courseId);
        this.setName(name);
        this.setCode(code);
        this.setCoefficient(coefficient);
        this.setTeacherId(teacherId);

    }

    private String Name;
    private int Code;
    private int courseId;
    private int Coefficient;
    private int TeacherId;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int id) {
        courseId = id;
    }

    public int getCoefficient() {
        return Coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        Coefficient = coefficient;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public Teacher getTeacher() {


        try {
            Controller controller = new Controller();
            return controller.loadTeacher(this.TeacherId);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setTeacherId(int teacherId) {
        TeacherId = teacherId;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher();
    }
}
