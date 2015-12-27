package Biz.Course;

import Biz.Teacher.Teacher;
import Biz.Teacher.TeacherBLO;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Course {

    public Course() {
    }

    public Course(int courseId, String name, int code, int coefficient, Teacher teacher) {

        this.setCourseId(courseId);
        this.setName(name);
        this.setCode(code);
        this.setCoefficient(coefficient);
        this.setTeacherId(teacher.getTeacherId());
        this.setTeacher(teacher);

    }

    public Course(int courseId, String name, int code, int coefficient, int teacherId) {

        this.setCourseId(courseId);
        this.setName(name);
        this.setCode(code);
        this.setCoefficient(coefficient);
        this.setTeacherId(teacherId);

    }

    private int courseId;
    private String name;
    private int code;
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
        return teacher;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return getName() + " - " + getTeacher();
    }


}
