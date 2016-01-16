package Biz.Student;

import Biz.Student.Student;
import Biz.StudentCourseMark;
import DAO.StudentDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 12/6/2015.
 */
public class StudentBLO {

    StudentDAO studentDAO;

    public StudentBLO() throws SQLException, ClassNotFoundException {

        studentDAO = new StudentDAO();
    }

    public List<Student> loadList() throws SQLException, ServletException, IOException {

        return studentDAO.loadList();

    }

    public Student loadByStudentId(int studentId) throws SQLException, ServletException, IOException {

        return studentDAO.loadByStudentId(studentId);

    }

    public Student loadByUserId(int userId) throws SQLException, ServletException, IOException {

        return studentDAO.loadByUserId(userId);

    }

    public void delete(int studentId) throws IOException, SQLException {

        studentDAO.delete(studentId);
    }

    public void save(Student student) throws SQLException, IOException {

        if (student.getStudentId() == 0) {
            add(student);

        } else {
            edit(student);

        }
    }

    private void add(Student student) throws SQLException {

        studentDAO.create(student);
    }

    private void edit(Student student) throws SQLException {

        studentDAO.update(student);
    }

    public List<StudentCourseMark> loadCoursesOfStudentByStudentId(int studentId) throws SQLException {
        return studentDAO.loadCoursesOfStudentByStudentId(studentId);
    }

    public void giveUpCourse(int courseId, int studentId) throws SQLException {
        studentDAO.giveUpCourse(courseId, studentId);
    }

    public void deleteStudentCourse(int studentCourseId) throws SQLException {
        studentDAO.deleteStudentCourse(studentCourseId);
    }

    public List<StudentCourseMark> loadTranscriptsOfStudentsByCourseId(int courseId) throws SQLException {
        return studentDAO.loadTranscriptsOfStudentsByCourseId(courseId);
    }
}


   