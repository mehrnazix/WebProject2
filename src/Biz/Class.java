package Biz;

import javax.print.attribute.DateTimeSyntax;
import java.sql.Time;
import java.util.Date;

/**
 * Created by 931664 on 12/8/2015.
 */
public class Class {

    public Class() {

    }

    public Class(int id, int teacherId, int courseId, String classNumber, String dateTime) {

        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.classNumber = classNumber;
        //this.date = date;
    }

    private int id;
    private int teacherId;
    private int courseId;
    private String classNumber;
    private DateTimeSyntax classDateTime;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DateTimeSyntax getClassDateTime() {
        return classDateTime;
    }

    public void setClassDateTime(DateTimeSyntax classDateTime) {
        this.classDateTime = classDateTime;
    }
}
