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
//        this.setTeacher(teacher);

    }

    private String name;
    private int code;
    private int courseId;
    private int coefficient;
    private int teacherId;
    private Teacher teacher;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int id) {
        courseId = id;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {

        try {
            Controller controller = new Controller();
            return controller.loadTeacher(this.teacherId);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher();
    }


}
