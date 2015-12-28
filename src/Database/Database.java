package Database;

import Biz.Course.Course;
import Biz.StudentCourseMark;
import Biz.Student.Student;
import Biz.Teacher.Teacher;
import Biz.User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 931664 on 11/15/2015.
 */
public class Database {

    Connection connectionString;

    public Database() {

    }

    public void connect() throws ClassNotFoundException, SQLException {

        if (this.connectionString == null) {

            java.lang.Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://swsql;user=sa; password=123; database=JavaTraining";
            this.connectionString = DriverManager.getConnection(connectionURL);
        }
    }

    public void disconnect() throws SQLException {

        if (this.connectionString != null) {

            this.connectionString.close();
        }
    }

    /*************
     * ********* User
     ***********/
    public User loadUser(String username, String password) throws SQLException {

        User user = null;
        String loadQuery = "SELECT u.Id user_id" +
                ",u.FirstName user_first_name" +
                ",u.LastName user_last_name" +
                ",u.NationalCode user_national_code" +
                ",u.Code user_code" +
                ",u.Email user_email" +
                ",u.PhoneNumber user_phone" +
                ",u.MobileNumber user_mobile" +
                ",u.Address user_address" +
                ",u.Username user_username" +
                ",u.Password user_password" +
                ",u.UserTypeId user_user_type_id " +
                "FROM JavaTraining.HM.Users AS U  " +
                "WHERE u.Username = ? AND u.Password =?";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            user = newUser(resultSet);
        }

        return user;
    }

    public User loadUserById(int userId) throws SQLException {

        User user = null;
        String loadQuery =
                "SELECT u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name, " +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email," +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "FROM JavaTraining.HM.Users AS U  WHERE u.id = ? ";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            user = newUser(resultSet);
        }

        return user;
    }

    private int insertUser(User user) throws SQLException {

        int userId = 0;
        String insertQuery = "INSERT INTO HM.Users" +
                "           (FirstName" +
                "           ,LastName" +
                "           ,NationalCode" +
                "           ,Code" +
                "           ,Email" +
                "           ,PhoneNumber" +
                "           ,MobileNumber" +
                "           ,Address" +
                "           ,Username" +
                "           ,Password" +
                "           ,UserTypeId)" +
                "     VALUES " +
                "           (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = this.connectionString.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setInt(3, user.getNationalCode());
        ps.setInt(4, user.getCode());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getPhoneNumber());
        ps.setInt(7, user.getMobileNumber());
        ps.setString(8, user.getAddress());
        ps.setInt(9, user.getCode());
        ps.setString(10, "123");
        ps.setInt(11, user.getUserTypeId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();

        if (rs != null && rs.next()) {
            userId = rs.getInt(1);
        }

        return userId;
    }

    private void updateUser(User user) throws SQLException {

        String editQuery = " UPDATE [HM].[Users]" +
                "               SET [FirstName] = ?, " +
                "                   [LastName] = ?," +
                "                   [NationalCode] = ?," +
                "                   [Code] = ? ," +
                "                   [Email] = ?," +
                "                   [PhoneNumber] =? ," +
                "                   [MobileNumber] = ?," +
                "                   [Address] = ?  " +
                "             Where [Id] = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(editQuery);
        ps.setString(1, user.getFirstName());
        ps.setString(2, user.getLastName());
        ps.setInt(3, user.getNationalCode());
        ps.setInt(4, user.getCode());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getPhoneNumber());
        ps.setInt(7, user.getMobileNumber());
        ps.setString(8, user.getAddress());
        ps.setInt(9, user.getUserId());
        ps.executeUpdate();

    }

    public void updatePasswordOfUser(User user) throws SQLException {
        String editQuery = " UPDATE [HM].[Users]" +
                "               SET [password] = ?  " +
                "             Where [Id] = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(editQuery);
        ps.setString(1, user.getPassword());
        ps.setInt(2, user.getUserId());
        ps.executeUpdate();
    }

    private void deleteUser(int userId) throws SQLException {

        String loadQuery = "delete from hm.users where id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);
        ps.executeUpdate();

    }

    private User newUser(ResultSet resultSet) throws SQLException {

        return new User(
                resultSet.getInt("user_id"),
                resultSet.getString("user_first_name"),
                resultSet.getString("user_last_name"),
                resultSet.getInt("user_national_code"),
                resultSet.getInt("user_code"),
                resultSet.getString("user_email"),
                resultSet.getInt("user_phone"),
                resultSet.getInt("user_mobile"),
                resultSet.getString("user_address"),
                resultSet.getString("user_username"),
                resultSet.getString("user_password"),
                resultSet.getInt("user_user_type_id")
        );
    }


    /*************
     * ********* Teacher
     ***********/
    /*Load All Teacher*/
    public ArrayList<Teacher> loadAllTeachers() throws SQLException {

        ArrayList teacherList = new ArrayList();
        String loadQuery =
                "select t.id teacher_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.teachers t inner join hm.users u on t.user_id = u.id order by u.Code ";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            teacherList.add(newTeacher(resultSet));
        }

        return teacherList;
    }

    /*Load Teacher*/
    public Teacher loadTeacherByTeacherId(int teacherId) throws SQLException {

        String loadQuery =
                "select t.id teacher_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.teachers t inner join hm.users u on t.user_id = u.id where t.id = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, teacherId);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet != null && resultSet.next()) {
            return newTeacher(resultSet);
        }

        return null;
    }

    /*Load Teacher by UserId*/
    public Teacher loadTeacherByUserId(int userId) throws SQLException {

        String loadQuery =
                "select t.id teacher_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.teachers t inner join hm.users u on t.user_id = u.id" +
                        "            where u.id = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet != null && resultSet.next()) {
            return newTeacher(resultSet);
        }

        return null;
    }

    /*Add Teacher*/
    public void addTeacher(Teacher teacher) throws SQLException {

        int userId = insertUser(teacher);
        insertTeacher(userId);
    }

    /*Edit Teacher*/
    public void editTeacher(Teacher teacher) throws SQLException {

        updateUser(teacher);
    }

    /*Delete Teacher*/
    public void deleteTeacher(int teacherId) throws SQLException {

        Teacher teacher = loadTeacherByTeacherId(teacherId);
        removeTeacher(teacherId);
        deleteUser(teacher.getUserId());
    }

    private Teacher newTeacher(ResultSet resultSet) throws SQLException {

        User user = newUser(resultSet);
        return new Teacher(
                resultSet.getInt("teacher_id"),
                user
        );
    }

    private void removeTeacher(int teacherId) throws SQLException {

        String deleteQuery = "delete from hm.teachers where id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(deleteQuery);
        ps.setInt(1, teacherId);
        ps.executeUpdate();

    }

    private void insertTeacher(int userId) throws SQLException {

        String insertQuery = "INSERT INTO HM.Teachers(user_id)  VALUES(?)";
        PreparedStatement ps = this.connectionString.prepareStatement(insertQuery);
        ps.setInt(1, userId);
        ps.executeUpdate();
    }

    /*************
     * ********* Student
     ***********/
    /*Load All Student*/
    public ArrayList<Student> loadAllStudents() throws SQLException {

        ArrayList studentList = new ArrayList();
        String loadQuery =
                "select s.id student_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.students s inner join hm.users u on s.user_id = u.id order by u.Code ";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            studentList.add(newStudent(resultSet));
        }

        return studentList;
    }

    /*Load Student*/
    public Student loadStudentByStudentId(int studentId) throws SQLException {

        String loadQuery =
                "select s.id student_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.students s inner join hm.users u on s.user_id = u.id where s.id = ? ";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, studentId);
        ResultSet resultSet = ps.executeQuery();


        if (resultSet != null && resultSet.next()) {
            return newStudent(resultSet);
        }

        return null;
    }

    public Student loadStudentByUserId(int userId) throws SQLException {

        String loadQuery =
                "select s.id student_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.students s inner join hm.users u on s.user_id = u.id where u.id = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet != null && resultSet.next()) {
            return newStudent(resultSet);
        }

        return null;
    }

    public void addStudent(Student student) throws SQLException {

        int userId = insertUser(student);
        insertStudent(userId);
    }

    public void editStudent(Student student) throws SQLException {

        updateUser(student);
    }

    public void deleteStudent(int studentId) throws SQLException {

        Student student = loadStudentByStudentId(studentId);
        removeStudent(studentId);
        deleteUser(student.getUserId());
    }

    private Student newStudent(ResultSet resultSet) throws SQLException {

        User user = newUser(resultSet);
        return new Student(
                resultSet.getInt("student_id"),
                user
        );
    }

    private void insertStudent(int userId) throws SQLException {

        String insertQuery = "INSERT INTO HM.Students(user_id)  VALUES(?)";
        PreparedStatement ps = this.connectionString.prepareStatement(insertQuery);
        ps.setInt(1, userId);
        ps.executeUpdate();
    }

    private void removeStudent(int studentId) throws SQLException {

        String deleteQuery = "delete from hm.students where id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(deleteQuery);
        ps.setInt(1, studentId);
        ps.executeUpdate();

    }

    /*************
     * ********* Course
     ***********/
    public ArrayList<Course> loadAllCourses() throws SQLException {

        ArrayList courseList = new ArrayList();
        String loadQuery =
                "select  c.id course_id, c.name course_name, c.coefficient course_coefficient, c.code course_code," +
                        "t.id teacher_id, u.Id user_id, u.FirstName user_first_name, u.LastName user_last_name," +
                        "u.NationalCode user_national_code, u.Code user_code, u.Email user_email," +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address," +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.courses c inner join hm.teachers t on c.teacher_id = t.id inner join hm.users u" +
                        " on u.id = t.user_id order by c.code";

        PreparedStatement psForLoadQuery = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = psForLoadQuery.executeQuery();

        while (resultSet.next()) {

            courseList.add(newCourse(resultSet));
        }

        return courseList;
    }

    public Course loadCourseByCourseId(int courseId) throws SQLException {

        Course course = null;
        String loadQuery =
                "select  c.id course_id, c.name course_name, c.coefficient course_coefficient, " +
                        "c.code course_code, t.id teacher_id, u.Id user_id, u.FirstName user_first_name, " +
                        "u.LastName user_last_name, u.NationalCode user_national_code, u.Code user_code, u.Email user_email, " +
                        "u.PhoneNumber user_phone, u.MobileNumber user_mobile, u.Address user_address, " +
                        "u.Username user_username, u.Password user_password, u.UserTypeId user_user_type_id " +
                        "from hm.courses c inner join hm.teachers t on c.teacher_id = t.id inner join hm.users u " +
                        "on u.id = t.user_id where c.id = ? order by c.code";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, courseId);
        ResultSet resultSet = ps.executeQuery();


        while (resultSet.next()) {

            course = newCourse(resultSet);
        }

        return course;
    }

    public void deleteCourse(int courseId) throws SQLException {

        String deleteQuery = "DELETE FROM HM.Courses WHERE Id = " + courseId;

        PreparedStatement ps = this.connectionString.prepareStatement(deleteQuery);
        ps.executeUpdate();
    }

    public void addCourse(Course course) throws SQLException {

        String insertQuery = "INSERT INTO HM.Courses " +
                "                (Name ,Code, Coefficient, Teacher_Id)" +
                "             VALUES (?, ?, ?, ?)";

        PreparedStatement ps = this.connectionString.prepareStatement(insertQuery);
        ps.setString(1, course.getName());
        ps.setInt(2, course.getCode());
        ps.setInt(3, course.getCoefficient());
        ps.setInt(4, course.getTeacherId());
        ps.executeUpdate();
    }

    public void editCourse(Course course) throws SQLException {

        String editQuery =
                " UPDATE HM.Courses" +
                        " SET " +
                        "        Name = ? " +
                        "       ,Code = ? " +
                        "       ,Coefficient = ?" +
                        "       ,teacher_Id = ?" +
                        " Where Id = ?";

        PreparedStatement ps = this.connectionString.prepareStatement(editQuery);
        ps.setString(1, course.getName());
        ps.setInt(2, course.getCode());
        ps.setInt(3, course.getCoefficient());
        ps.setInt(4, course.getTeacherId());
        ps.setInt(5, course.getCourseId());
        ps.executeUpdate();
    }

    private Course newCourse(ResultSet resultSet) throws SQLException {

        Teacher teacher = newTeacher(resultSet);
        return new Course(
                resultSet.getInt("course_id"),
                resultSet.getString("course_name"),
                resultSet.getInt("course_code"),
                resultSet.getInt("course_coefficient"),
                teacher
        );
    }


    /*************
     * ********* StudentCourseMark
     ***********/
    public List<StudentCourseMark> loadCoursesOfStudentByStudentId(int studentId) throws SQLException {

        ArrayList gradeList = new ArrayList();
        String loadQuery =
                "select g.student_id student_id, g.id grade_id, g.score grade_score, c.id course_id, c.name course_name, " +
                        "c.coefficient course_coefficient, c.code course_code, t.id teacher_id, u.Id user_id, " +
                        "u.FirstName user_first_name, u.LastName user_last_name, u.NationalCode user_national_code," +
                        "u.Code user_code, u.Email user_email, u.PhoneNumber user_phone, u.MobileNumber user_mobile," +
                        "u.Address user_address, u.Username user_username, u.Password user_password, " +
                        "u.UserTypeId user_user_type_id " +
                        "from hm.Student_Course_Mark g inner join hm.courses c on g.course_Id = c.id inner join hm.teachers t " +
                        "on t.id = c.teacher_id inner join hm.users u on u.id = t.user_id where g.student_id = ? " +
                        "order by c.code";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, studentId);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            gradeList.add(newStudent_Course_Mark(resultSet));
        }

        return gradeList;
    }

    public List<StudentCourseMark> loadStudentCourseListByTeacherId(int teacherId) throws SQLException {

        ArrayList gradeList = new ArrayList();
        String loadQuery =
                "select g.student_id student_id, g.id grade_id, g.score grade_score, c.id course_id, c.name course_name, " +
                        "c.coefficient course_coefficient, c.code course_code, c.teacher_id teacher_id, u.Id user_id, " +
                        "u.FirstName user_first_name, u.LastName user_last_name, u.NationalCode user_national_code," +
                        "u.Code user_code, u.Email user_email, u.PhoneNumber user_phone, u.MobileNumber user_mobile," +
                        "u.Address user_address, u.Username user_username, u.Password user_password, " +
                        "u.UserTypeId user_user_type_id " +
                        "from hm.Student_Course_Mark g inner join hm.courses c on g.course_Id = c.id inner join hm.students s " +
                        "on s.id = g.student_id inner join hm.users u on u.id = s.user_id where c.teacher_id = ? " +
                        "order by c.code";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, teacherId);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            gradeList.add(newStudent_Course_Mark(resultSet));
        }

        return gradeList;
    }

    public StudentCourseMark newStudent_Course_Mark(ResultSet resultSet) throws SQLException {

        Course course = newCourse(resultSet);
        Student student = newStudent(resultSet);
        return new StudentCourseMark(resultSet.getInt("grade_id"), student, course, resultSet.getInt("grade_score"));
    }

    public void addStudentCourseMark(int courseId, int studentId) throws SQLException {

        String insertQuery = "INSERT INTO HM.Student_Course_Mark (student_id ,course_id) VALUES (?, ?)";

        PreparedStatement ps = this.connectionString.prepareStatement(insertQuery);
        ps.setInt(1, studentId);
        ps.setInt(2, courseId);
        ps.executeUpdate();
    }

    public void deleteStudentCourse(int gradeId) throws SQLException {

        String deleteQuery = "DELETE FROM HM.Student_Course_Mark WHERE Id = " + gradeId;

        PreparedStatement ps = this.connectionString.prepareStatement(deleteQuery);
        ps.executeUpdate();

    }

    public void updateStudent_Course_Mark(int gradeId, int score) throws SQLException {

        String updateQuery = "update HM.Student_Course_Mark set score = ? WHERE Id = " + gradeId;

        PreparedStatement ps = this.connectionString.prepareStatement(updateQuery);
        ps.setInt(1, score);
        ps.setInt(2, gradeId);

        ps.executeUpdate();
    }
}
