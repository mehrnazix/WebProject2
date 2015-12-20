package Biz;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Teacher extends User {

    public Teacher() {

    }

    public Teacher(int userId, int teacherId, String firstName, String lastName, int nationalCode, int userCode, String email,
                   int phoneNumber, int mobileNumber, String address) {

        super(userId, firstName, lastName, nationalCode, userCode, email,
                phoneNumber, mobileNumber, address, 2);
        setTeacherId(teacherId);
    }

    private int teacherId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int id) {
        this.teacherId = id;
    }


}
