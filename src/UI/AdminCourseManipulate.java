package UI;

import Biz.Controller;
import Biz.Course;
import Biz.Course;
import Biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 931664 on 12/6/2015.
 */
public class AdminCourseManipulate {

    Controller controller;
    HttpServletRequest requet;
    HttpServletResponse response;

    public AdminCourseManipulate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        requet = req;
        response = res;

        controller = new Controller();
    }

    /*main page: use in url*/
    public void view() throws SQLException, ServletException, IOException {

        List<Course> courses = controller.loadAllCourses();
        HttpSession session = requet.getSession();
        session.setAttribute("courseList", courses);

        RequestDispatcher view = requet.getRequestDispatcher("/JSP/viewCourses.jsp");
        view.forward(requet, response);

    }

    /*create new course: use in url*/
    public void create() throws ServletException, SQLException, IOException {

        dispatchToAddOrEditCourseJsp(new Course());
    }

    /*update selected course: use in url*/
    public void update() throws SQLException, ServletException, IOException {

        int courseId = (int) requet.getAttribute("id");
        Course course = controller.loadCourse(courseId);
        dispatchToAddOrEditCourseJsp(course);

    }

    public void delete() throws IOException, SQLException {

        int courseId = (int) requet.getAttribute("id");
        controller.deleteCourseFromDatabase(courseId);
        response.sendRedirect("/course");
    }

    public void save() throws IOException, ServletException {

        Integer courseId = Integer.parseInt(requet.getParameter("id"));
        String courseName = requet.getParameter("name");
        Integer courseCode = Integer.parseInt(requet.getParameter("code"));
        Integer coefficient = Integer.parseInt(requet.getParameter("coefficient"));
        Integer courseTeacherId = Integer.parseInt(requet.getParameter("teacherId"));

        Course course = new Course(courseId, courseName, courseCode, coefficient, courseTeacherId);

        if (courseId == 0) {
            add(course);
        } else {
            edit(course);
        }

        response.sendRedirect("/course");
    }

    private void add(Course course) throws IOException, ServletException {

        try {
            controller.addCourseToDatabase(course);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void edit(Course course) {

        try {
            controller.editCourseInDatabase(course);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dispatchToAddOrEditCourseJsp(Course course) throws SQLException, ServletException, IOException {

        List<Teacher> teachers = controller.loadTeachers();

        requet.setAttribute("course", course);
        requet.setAttribute("teachers", teachers);

        RequestDispatcher view = requet.getRequestDispatcher("/JSP/addOrEditCourse.jsp");
        view.forward(requet, response);
    }
}
