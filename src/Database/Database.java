package Database;

import Biz.*;
import Biz.Class;

import java.sql.*;
import java.util.ArrayList;

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
        String loadQuery = "SELECT u.* FROM JavaTraining.HM.Users AS U  WHERE u.Username = ? AND u.Password =?";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            user = new User(
                    resultSet.getInt("Id"),
                    resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getInt("NationalCode"),
                    resultSet.getInt("Code"),
                    resultSet.getString("Email"),
                    resultSet.getInt("PhoneNumber"),
                    resultSet.getInt("MobileNumber"),
                    resultSet.getString("Address"),
                    resultSet.getInt("UserTypeId")
            );
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

    private void deleteUser(int userId) throws SQLException {

        String loadQuery = "delete from hm.users where id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);
        ps.executeUpdate();

    }

    /*************
     * ********* Teacher
     ***********/
    /*Load All Teacher*/
    public ArrayList<Teacher> loadTeachers() throws SQLException {

        ArrayList teacherList = new ArrayList();
        String loadQuery = "select t.id teacher_id, u.*" +
                "             from hm.teachers t " +
                "       inner join hm.users u " +
                "               on t.user_id = u.id " +
                "         order by u.Code ";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            teacherList.add(newTeacher(resultSet));
        }

        return teacherList;
    }

    /*Load Teacher*/
    public Teacher loadTeacher(int teacherId) throws SQLException {

        String loadQuery = "select t.id teacher_id, u.* " +
                "             from hm.teachers t " +
                "       inner join hm.users u " +
                "               on t.user_id = u.id " +
                "            where t.id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, teacherId);
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

        Teacher teacher = loadTeacher(teacherId);
        removeTeacher(teacherId);
        deleteUser(teacher.getUserId());
    }

    private Teacher newTeacher(ResultSet resultSet) throws SQLException {

        return new Teacher(
                resultSet.getInt("id"),
                resultSet.getInt("teacher_id"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName"),
                resultSet.getInt("NationalCode"),
                resultSet.getInt("Code"),
                resultSet.getString("Email"),
                resultSet.getInt("PhoneNumber"),
                resultSet.getInt("MobileNumber"),
                resultSet.getString("Address")
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

    /*Load Teacher by UserId*/
    public Teacher loadTeacherByUserId(int userId) throws SQLException {

        String loadQuery = "select t.id teacher_id, u.* " +
                "             from hm.teachers t " +
                "       inner join hm.users u " +
                "               on t.user_id = u.id " +
                "            where u.id = ?";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, userId);
        ResultSet resultSet = ps.executeQuery();

        if (resultSet != null && resultSet.next()) {
            return newTeacher(resultSet);
        }

        return null;
    }

    /*************
     * ********* Student
     ***********/
    /*Load All Student*/
    public ArrayList<Student> loadAllStudents() throws SQLException {

        ArrayList studentList = new ArrayList();
        String loadQuery = "select s.id student_id, u.*" +
                "             from hm.students s " +
                "       inner join hm.users u " +
                "               on s.user_id = u.id " +
                "         order by u.Code ";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            studentList.add(newStudent(resultSet));
        }

        return studentList;
    }

    /*Load Student*/
    public Student loadStudent(Integer studentId) throws SQLException {

        String loadQuery = "select s.id student_id, u.*" +
                "             from hm.students s " +
                "       inner join hm.users u " +
                "               on s.user_id = u.id " +
                "            where s.id = ? ";
        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, studentId);
        ResultSet resultSet = ps.executeQuery();


        if (resultSet != null && resultSet.next()) {
            return newStudent(resultSet);
        }

        return null;
    }

    /*Add Student*/
    public void addStudent(Student student) throws SQLException {

        int userId = insertUser(student);
        insertStudent(userId);
    }

    /*Edit Student*/
    public void editStudent(Student student) throws SQLException {

        updateUser(student);
    }

    /*Delete Student*/
    public void deleteStudent(Integer studentId) throws SQLException {

        Student student = loadStudent(studentId);
        removeStudent(studentId);
        deleteUser(student.getUserId());
    }

    private Student newStudent(ResultSet resultSet) throws SQLException {

        return new Student(
                resultSet.getInt("id"),
                resultSet.getInt("student_id"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName"),
                resultSet.getInt("NationalCode"),
                resultSet.getInt("Code"),
                resultSet.getString("Email"),
                resultSet.getInt("PhoneNumber"),
                resultSet.getInt("MobileNumber"),
                resultSet.getString("Address")
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
    /*Load All Course*/
    public ArrayList<Course> loadAllCourses() throws SQLException {

        ArrayList courseList = new ArrayList();
        String loadQuery = "  select c.id course_id, c.name course_name, c.coefficient course_coefficient, " +
                "                   c.code course_code, t.id teacher_id" +
                "               from hm.courses c" +
                "         inner join hm.teachers t" +
                "                 on c.teacher_id = t.id" +
                "           order by c.code";
        PreparedStatement psForLoadQuery = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = psForLoadQuery.executeQuery();

        while (resultSet.next()) {

            courseList.add(newCourse(resultSet));
        }

        return courseList;
    }

    /*Load Course*/
    public Course loadCourse(Integer courseId) throws SQLException {

        Course course = null;
        String loadQuery = "  select c.id course_id, c.name course_name, c.coefficient course_coefficient, " +
                "                   c.code course_code, t.id teacher_id" +
                "               from hm.courses c" +
                "         inner join hm.teachers t" +
                "                 on c.teacher_id = t.id" +
                "               where c.id = ?" +
                "           order by c.code";

        PreparedStatement ps = this.connectionString.prepareStatement(loadQuery);
        ps.setInt(1, courseId);
        ResultSet resultSet = ps.executeQuery();


        while (resultSet.next()) {

//            Teacher teacher = newTeacher(resultSet);
            course = newCourse(resultSet);
        }

        return course;
    }

    /*Delete Course*/
    public void deleteCourse(Integer courseId) throws SQLException {

        String deleteQuery = "DELETE FROM HM.Courses WHERE Id = " + courseId;

        PreparedStatement ps = this.connectionString.prepareStatement(deleteQuery);
        ps.executeUpdate();
    }

    /*Add Course*/
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

    /*Edit Teacher*/
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
        return new Course(
                resultSet.getInt("course_id"),
                resultSet.getString("course_name"),
                resultSet.getInt("course_code"),
                resultSet.getInt("course_coefficient"),
                resultSet.getInt("teacher_id")
        );
    }

    /*Classes*/
    /*Load All Class*/
    public ArrayList<Class> loadAllClasses() throws SQLException {

        ArrayList classList = new ArrayList();
        Class cls = null;

        String loadQuery = "SELECT * FROM [HM].[Class] order by Id";
        PreparedStatement psForLoadQuery = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = psForLoadQuery.executeQuery();

        while (resultSet.next()) {

            cls = new Class(
                    resultSet.getInt("Id"),
                    resultSet.getInt("teacherId"),
                    resultSet.getInt("courseId"),
                    resultSet.getString("classNumber"),
                    resultSet.getString("[ClassDateTime]")
            );

            classList.add(cls);
        }

        return classList;
    }

    /*Load Class*/
    public Class loadClass(Integer classId) throws SQLException {


        Class cls = null;

        String loadQuery = "SELECT * FROM [HM].[Class] where id = " + classId + " order by id ";
        PreparedStatement psForLoadQuery = this.connectionString.prepareStatement(loadQuery);
        ResultSet resultSet = psForLoadQuery.executeQuery();


        while (resultSet.next()) {
            cls = new Class(
                    resultSet.getInt("Id"),
                    resultSet.getInt("teacherId"),
                    resultSet.getInt("courseId"),
                    resultSet.getString("classNumber"),
                    resultSet.getString("[ClassDateTime]")
            );
        }

        return cls;
    }

    /*Delete Student*/
    public void deleteClass(int classId) throws SQLException {

        String deleteQuery = "DELETE FROM [HM].[Class]\n" +
                "      WHERE Id = " + classId;

        PreparedStatement preparedStatementForClassDeleteQuery = this.connectionString.prepareStatement(deleteQuery);
        preparedStatementForClassDeleteQuery.executeUpdate();
    }

    /*Add Student*/
    public void addClass(Class cls) throws SQLException {

        String insertQuery = "INSERT INTO [HM].[Class]\n" +
                "           ([teacherId]\n" +
                "           ,[courseId]\n" +
                "           ,[classNumber]" +
                "           ,[date]" +
                "           ,[time])" +
                "     VALUES( " + cls.getTeacherId() +
                "            ," + cls.getCourseId() +
                "            ,'" + cls.getClassNumber() + "'" +
                "            ,'" + cls.getClassDateTime() + "'" +
                ")";

        PreparedStatement preparedStatementForClassInsertQuery = this.connectionString.prepareStatement(insertQuery);
        preparedStatementForClassInsertQuery.executeUpdate();
    }


    /*Edit Teacher*/
    public void editClass(Class cls) throws SQLException {

        String editQuery =
                "UPDATE [HM].[Class]" +
                        " SET" +
                        "   [teacherId] = '" + cls.getTeacherId() +
                        "' ,[courseId] = " + cls.getCourseId() +
                        "  ,[classNumber] = " + cls.getClassNumber() +
                        "  ,[date] = " + cls.getClassDateTime() +
                        " Where [Id] = " + cls.getId();

        PreparedStatement preparedStatementForClassEditQuery = this.connectionString.prepareStatement(editQuery);
        preparedStatementForClassEditQuery.executeUpdate();
    }
}
