package Biz;

import Biz.Course.Course;
import Biz.Student.Student;
import Biz.Teacher.Teacher;

/**
 * Created by 931664 on 11/25/2015.
 */
public class Grade {
    public Grade() {

    }

    private Course course;
    private Teacher teacher;
    private Student student;
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

}
