package UI;

import Biz.Controller;
import Biz.Course;
import Biz.Teacher;

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
 */
public class AdminCourseManipulate {

    private Controller controller;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public AdminCourseManipulate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        request = req;
        response = res;

        controller = new Controller();
    }

    /*main page: use in url*/
    public void view() throws SQLException, ServletException, IOException {

        List<Course> courses = controller.loadAllCourses();
        HttpSession session = request.getSession();
        session.setAttribute("courseList", courses);

        RequestDispatcher view = request.getRequestDispatcher("/JSP/viewCourses.jsp");
        view.forward(request, response);

    }

    /*create new course: use in url*/
    public void create() throws ServletException, SQLException, IOException {

        directToAddOrEditCourseJsp(new Course());
    }

    /*update selected course: use in url*/
    public void update() throws SQLException, ServletException, IOException {

        int courseId = (int) request.getAttribute("id");
        Course course = controller.loadCourse(courseId);
        directToAddOrEditCourseJsp(course);

    }

    public void delete() throws IOException, SQLException {

        int courseId = (int) request.getAttribute("id");
        controller.deleteCourseFromDatabase(courseId);
        response.sendRedirect("/admin/viewCourses");
    }

    public void save() throws SQLException, IOException {

        Integer courseId = Integer.parseInt(request.getParameter("id"));
        String courseName = request.getParameter("name");
        Integer courseCode = Integer.parseInt(request.getParameter("code"));
        Integer coefficient = Integer.parseInt(request.getParameter("coefficient"));
        Integer courseTeacherId = Integer.parseInt(request.getParameter("teacherId"));

        Course course = new Course(courseId, courseName, courseCode, coefficient, courseTeacherId);

        if (courseId == 0) {
            add(course);
        } else {
            edit(course);
        }

        response.sendRedirect("/admin/viewCourses");
    }

    private void add(Course course) throws SQLException {

        controller.addCourseToDatabase(course);
    }

    private void edit(Course course) throws SQLException {

        controller.editCourseInDatabase(course);
    }

    private void directToAddOrEditCourseJsp(Course course) throws SQLException, ServletException, IOException {

        List<Teacher> teachers = controller.loadTeachers();

        request.setAttribute("course", course);
        request.setAttribute("teachers", teachers);

        RequestDispatcher view = request.getRequestDispatcher("/JSP/addOrEditCourse.jsp");
        view.forward(request, response);
    }
}
