package Biz.Teacher;

import Biz.StudentCourseMark;
import Biz.Teacher.Teacher;
import DAO.TeacherDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 12/15/2015.
 */
public class TeacherBLO {

    private TeacherDAO teacherDAO;

    public TeacherBLO() throws SQLException, ClassNotFoundException {

        teacherDAO = new TeacherDAO();
    }

    public List<Teacher> loadList() throws SQLException, ServletException, IOException {

        return teacherDAO.loadList();

    }

    public Teacher loadByTeacherId(int teacherId) throws SQLException, ServletException, IOException {

        return teacherDAO.loadByTeacherId(teacherId);

    }

    public Teacher loadByUserId(int userId) throws SQLException, ServletException, IOException {

        return teacherDAO.loadByUserId(userId);

    }

    public void delete(int teacherId) throws SQLException, IOException {

        teacherDAO.delete(teacherId);
    }

    public void save(Teacher teacher) throws IOException, SQLException {

        if (teacher.getTeacherId() == 0) {
            addTeacher(teacher);
        } else {
            editTeacher(teacher);
        }
    }

    private void addTeacher(Teacher teacher) throws SQLException {

        teacherDAO.create(teacher);
    }

    private void editTeacher(Teacher teacher) throws SQLException {

        teacherDAO.update(teacher);
    }

    public List<StudentCourseMark> loadStudentCourseListByTeacherId(int teacherId) throws SQLException {
        return teacherDAO.loadStudentCourseListByTeacherId(teacherId);
    }

    public void updateScore(int gradeId, int score) throws SQLException {
        teacherDAO.updateScore(gradeId, score);
    }

//    public StudentCourseMark loadStudentCourseByTeacherId(int gradeId) {
//        return teacherDAO.loadStudentCourseByTeacherId(gradeId);
//    }
}
