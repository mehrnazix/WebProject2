package Biz.Course;

import Biz.Course.Course;
import Biz.Teacher.Teacher;
import DAO.CourseDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 12/6/2015.
 ***/
public class CourseBLO {

    private CourseDAO courseDAO;

    public CourseBLO() throws SQLException, ClassNotFoundException {

        courseDAO = new CourseDAO();
    }

    public List<Course> loadList() throws SQLException, ServletException, IOException {

        return courseDAO.loadList();
    }

    public Course loadByCourseId(int courseId) throws SQLException, ServletException, IOException {

        return courseDAO.loadByCourseId(courseId);
    }

    public List<Teacher> loadTeacherList() throws SQLException, ServletException, IOException {

        return courseDAO.loadTeacherList();
    }

    public void delete(int courseId) throws IOException, SQLException {

        courseDAO.delete(courseId);
    }

    public void save(Course course) throws SQLException, IOException {

        if (course.getCourseId() == 0) {
            add(course);
        } else {
            edit(course);
        }
    }

    private void add(Course course) throws SQLException {

        courseDAO.create(course);
    }

    private void edit(Course course) throws SQLException {

        courseDAO.update(course);
    }


}
