package Biz.Teacher;

import Biz.User.User;

/**
 * Created by 931664 on 11/11/2015.
 */
public class Teacher extends User {

    public Teacher() {

    }

    public Teacher(int teacherId, User user) {

        super(user.getUserId(), user.getFirstName(), user.getLastName(), user.getNationalCode(), user.getCode(),
                user.getEmail(), user.getPhoneNumber(), user.getMobileNumber(), user.getAddress(), 2);
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
