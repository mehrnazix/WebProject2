package Biz;

import Database.Database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 11/16/2015.
 */
public class Controller {

    private Database database;

    public Controller() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    /*******
     * Teacher
     *******/
    public List<Teacher> loadTeachers() throws SQLException {
        return database.loadTeachers();
    }

    public Teacher loadTeacher(Integer teacherId) throws SQLException {
        return database.loadTeacher(teacherId);
    }

    public void addTeacher(Teacher teacher) throws SQLException {
        database.addTeacher(teacher);
    }

    public void editTeacher(Teacher teacher) throws SQLException {
        database.editTeacher(teacher);
    }

    public void deleteTeacher(Integer teacherId) throws SQLException {
        database.deleteTeacher(teacherId);
    }

    /*******
     * Student
     *******/
    public List<Student> loadAllStudents() throws SQLException {
        return database.loadAllStudents();
    }

    public Student loadStudent(Integer studentId) throws SQLException {
        return database.loadStudent(studentId);
    }

    public void addStudentToDatabase(Student student) throws SQLException {
        database.addStudent(student);
    }

    public void editStudentInDatabase(Student student) throws SQLException {
        database.editStudent(student);
    }

    public void deleteStudentFromDatabase(Integer studentId) throws SQLException {
        database.deleteStudent(studentId);
    }

    /* Course */
    public List<Course> loadAllCourses() throws SQLException {
        return database.loadAllCourses();
    }

    public Course loadCourse(Integer courseId) throws SQLException {
        return database.loadCourse(courseId);
    }

    public void addCourseToDatabase(Course course) throws SQLException {
        database.addCourse(course);
    }

    public void editCourseInDatabase(Course course) throws SQLException {
        database.editCourse(course);
    }

    public void deleteCourseFromDatabase(Integer courseId) throws SQLException {
        database.deleteCourse(courseId);
    }


    /* Class */
    public List<Class> loadAllClasses() throws SQLException {
        return database.loadAllClasses();
    }

    public Class loadClass(int classId) throws SQLException {
        return database.loadClass(classId);
    }

    public void addClassToDatabase(Class cls) throws SQLException {
        database.addClass(cls);
    }

    public void editClassInDatabase(Class cls) throws SQLException {
        database.editClass(cls);
    }

    public void deleteClassFromDatabase(int classId) throws SQLException {
        database.deleteClass(classId);
    }

    public User loadUser(String userName, String password) throws SQLException {
        return database.loadUser(userName, password);
    }
}
