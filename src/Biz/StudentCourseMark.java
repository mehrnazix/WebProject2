package Biz;

import Biz.Course.Course;
import Biz.Student.Student;

/**
 * Created by 931664 on 11/25/2015.
 */
public class StudentCourseMark {

    public StudentCourseMark() {

    }

    public StudentCourseMark(int id, Student student, Course course, int score) {

        setStudentCourseMarkId(id);
        setStudent(student);
        setStudentId(student.getStudentId());
        setCourse(course);
        setCourseId(course.getCourseId());
        setScore(score);
    }

    private int studentCourseMarkId;
    private int studentId;
    private int courseId;
    private int score;
    private Student student;
    private Course course;

    public int getStudentCourseMarkId() {
        return studentCourseMarkId;
    }

    public void setStudentCourseMarkId(int studentCourseMarkId) {
        this.studentCourseMarkId = studentCourseMarkId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }
}
