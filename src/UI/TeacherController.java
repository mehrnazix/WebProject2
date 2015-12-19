package UI;

import Biz.Controller;
import Biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class TeacherController extends BaseController {

    Controller controller;

    /*main page: use in url*/
    public void index() {

        try {
            controller = new Controller();
            List<Teacher> teachers = controller.loadTeachers();

            HttpSession session = Request.getSession();
            session.setAttribute("teacherList", teachers);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewTeachers.jsp");
            view.forward(Request, Response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*create new teacher: use in url*/
    public void create() throws ServletException, IOException {

        dispatchToAddOrEditTeacherJsp(new Teacher());
    }

    /*update selected teacher: use in url*/
    public void update() {

        Integer teacherId = (Integer) Request.getAttribute("id");

        try {
            Teacher teacher = controller.loadTeacher(teacherId);
            dispatchToAddOrEditTeacherJsp(teacher);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() throws IOException {

        Integer teacherId = (Integer) Request.getAttribute("id");

        try {
            controller.deleteTeacher(teacherId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Response.sendRedirect("/teacher");
    }

    public void save() throws IOException, ServletException {

        Integer teacherId = Integer.parseInt(Request.getParameter("id"));
        String firstName = Request.getParameter("firstName");
        String lastName = Request.getParameter("lastName");
        Integer nationalCode = Integer.parseInt(Request.getParameter("nationalCode"));
        Integer teacherCode = Integer.parseInt(Request.getParameter("teacherCode"));
        String email = Request.getParameter("email");
        Integer phoneNumber = Integer.parseInt(Request.getParameter("phoneNumber"));
        Integer mobileNumber = Integer.parseInt(Request.getParameter("mobileNumber"));
        String address = Request.getParameter("address");

        Teacher teacher = new Teacher();

        if (teacherId == 0) {
            add(teacher);
        } else {
            edit(teacher);
        }

        Response.sendRedirect("/teacher");
    }

    private void add(Teacher teacher) throws IOException, ServletException {

        try {
            controller.addTeacher(teacher);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void edit(Teacher teacher) {

        try {
            controller.editTeacher(teacher);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dispatchToAddOrEditTeacherJsp(Teacher teacher) throws ServletException, IOException {
        Request.setAttribute("teacher", teacher);
        RequestDispatcher view = Request.getRequestDispatcher("/JSP/addOrEditTeacher.jsp");
        view.forward(Request, Response);
    }
}
