package Biz.User;

/**
 * Created by 931664 on 11/11/2015.
 */
public class User {

    public User() {

    }

    public User(int id, String firstName, String lastName, int nationalCode, int userCode, String email,
                int phoneNumber, int mobileNumber, String address, int userTypeId) {

        setUserId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setNationalCode(nationalCode);
        setCode(userCode);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setMobileNumber(mobileNumber);
        setAddress(address);
        setUserTypeId(userTypeId);
    }

    public User(int id, String firstName, String lastName, int nationalCode, int userCode, String email,
                int phoneNumber, int mobileNumber, String address, String username, String password, int userTypeId) {

        this(id, firstName, lastName, nationalCode, userCode, email, phoneNumber, mobileNumber, address, userTypeId);

        setUsername(username);
        setPassword(password);
    }

    public User(int id, String password) {

        setUserId(id);
        setPassword(password);
    }

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private int nationalCode;
    private int code;
    private String email;
    private int phoneNumber;
    private int mobileNumber;
    private String address;
    private int UserId;
    private int userTypeId;
    private UserType userType;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int id) {
        this.UserId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int userCode) {
        this.code = userCode;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }


    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

//    public enum UserType {
//        admin,
//        teacher,
//        student
//    }

}
