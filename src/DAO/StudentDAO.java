package DAO;

import Biz.StudentCourseMark;
import Biz.Student.Student;
import Database.Database;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 11/16/2015.
 */
public class StudentDAO {

    private Database database;

    public StudentDAO() throws SQLException, ClassNotFoundException {
        database = new Database();
        database.connect();
    }

    public void create(Student student) throws SQLException {

        database.addStudent(student);
    }

    public void update(Student student) throws SQLException {

        database.editStudent(student);
    }

    public void delete(int studentId) throws SQLException {

        database.deleteStudent(studentId);
    }

    public List<Student> loadList() throws SQLException {

        return database.loadAllStudents();
    }

    public Student loadByStudentId(int studentId) throws SQLException {

        return database.loadStudentByStudentId(studentId);
    }

    public Student loadByUserId(Integer userId) throws SQLException {

        return database.loadStudentByUserId(userId);
    }

    public List<StudentCourseMark> loadCoursesOfStudentByStudentId(int studentId) throws SQLException {

        return database.loadCoursesOfStudentByStudentId(studentId);
    }

    public List<StudentCourseMark> loadTranscriptsOfStudentsByCourseId(int courseId) throws SQLException {

        return database.loadTranscriptsOfStudentsByCourseId(courseId);
    }

    public void giveUpCourse(int courseId, int studentId) throws SQLException {
        database.addStudentCourseMark(courseId, studentId);
    }

    public void deleteStudentCourse(int gradeId) throws SQLException {
        database.deleteStudentCourse(gradeId);
    }
}
