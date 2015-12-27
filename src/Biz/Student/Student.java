package Biz.Student;

import Biz.User.User;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Student extends User {

    public Student() {

    }

    public Student(int studentId, User user) {

        super(user.getUserId(), user.getFirstName(), user.getLastName(), user.getNationalCode(), user.getCode(),
                user.getEmail(), user.getPhoneNumber(), user.getMobileNumber(), user.getAddress(), 3);

        setStudentId(studentId);
    }

    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }


}
