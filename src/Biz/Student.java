package Biz;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Student extends User {

    public Student() {

    }

    public Student(int userId, int studentId, String firstName, String lastName, int nationalCode, int userCode, String email,
                   int phoneNumber, int mobileNumber, String address) {

        super(userId, firstName, lastName, nationalCode, userCode, email,
                phoneNumber, mobileNumber, address, 3);

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
