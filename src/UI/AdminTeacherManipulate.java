package UI;

import Biz.Controller;
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
 * Created by 931664 on 12/15/2015.
 */
public class AdminTeacherManipulate {

    private Controller controller;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public AdminTeacherManipulate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        request = req;
        response = res;
        controller = new Controller();
    }


    public void view() throws SQLException, ServletException, IOException {

        List<Teacher> teachers = controller.loadTeachers();
        HttpSession session = request.getSession();
        session.setAttribute("teacherList", teachers);

        RequestDispatcher view = request.getRequestDispatcher("/JSP/viewTeachers.jsp");
        view.forward(request, response);

    }

    /*create new teacher: use in url*/
    public void create() throws ServletException, IOException {

        redirectToAddOrEditTeacherJsp(new Teacher());
    }

    /*update selected teacher: use in url*/
    public void update() throws SQLException, ServletException, IOException {

        int teacherId = (int) request.getAttribute("id");
        Teacher teacher = controller.loadTeacher(teacherId);
        redirectToAddOrEditTeacherJsp(teacher);

    }

    /*delete selected teacher: use in url*/
    public void delete() throws SQLException, IOException {

        int teacherId = (int) request.getAttribute("id");
        controller.deleteTeacher(teacherId);
        response.sendRedirect("/admin/viewTeachers");
    }

    /*seve selected teacher: use for add and edit teacher in form*/
    public void save() throws IOException, SQLException {

        Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Integer nationalCode = Integer.parseInt(request.getParameter("nationalCode"));
        Integer teacherCode = Integer.parseInt(request.getParameter("code"));
        String email = request.getParameter("email");
        Integer phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        Integer mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
        String address = request.getParameter("address");

        Teacher teacher = new Teacher(userId, teacherId, firstName, lastName, nationalCode, teacherCode, email,
                phoneNumber, mobileNumber, address);

        if (teacherId == 0) {
            addTeacher(teacher);
        } else {
            editTeacher(teacher);
        }

        response.sendRedirect("/admin/viewTeachers");
    }

    private void redirectToAddOrEditTeacherJsp(Teacher teacher) throws ServletException, IOException {

        request.setAttribute("teacher", teacher);
        RequestDispatcher view = request.getRequestDispatcher("/JSP/addOrEditTeacher.jsp");
        view.forward(request, response);

    }

    private void addTeacher(Teacher teacher) throws SQLException {

        controller.addTeacher(teacher);
    }

    private void editTeacher(Teacher teacher) throws SQLException {

        controller.editTeacher(teacher);
    }

}
