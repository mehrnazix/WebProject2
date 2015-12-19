package UI;

import Biz.Controller;
import Biz.Student;

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
public class AdminStudentManipulate {

    Controller controller;
    HttpServletRequest request;
    HttpServletResponse response;

    public AdminStudentManipulate(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        request = req;
        response = res;
        controller = new Controller();
    }

    /*main page: use in url*/
    public void view() throws SQLException, ServletException, IOException {

        List<Student> students = controller.loadAllStudents();
        HttpSession session = request.getSession();
        session.setAttribute("studentList", students);

        RequestDispatcher view = request.getRequestDispatcher("/JSP/viewStudents.jsp");
        view.forward(request, response);
    }

    /*create new student: use in url*/
    public void create() throws ServletException, IOException {

        redirectToAddOrEditStudentJsp(new Student());
    }

    /*update selected student: use in url*/
    public void update() throws SQLException, ServletException, IOException {

        int studentId = (int) request.getAttribute("id");
        Student student = controller.loadStudent(studentId);
        redirectToAddOrEditStudentJsp(student);
    }

    public void delete() throws IOException, SQLException {

        int studentId = (int) request.getAttribute("id");
        controller.deleteStudentFromDatabase(studentId);
        response.sendRedirect("/admin/viewStudents");
    }

    public void save() throws SQLException, IOException {

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Integer nationalCode = Integer.parseInt(request.getParameter("nationalCode"));
        Integer studentCode = Integer.parseInt(request.getParameter("code"));
        String email = request.getParameter("email");
        Integer phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));
        Integer mobileNumber = Integer.parseInt(request.getParameter("mobileNumber"));
        String address = request.getParameter("address");

        Student student = new Student(userId, studentId, firstName, lastName, nationalCode, studentCode, email,
                phoneNumber, mobileNumber, address);

        if (studentId == 0) {
            add(student);
        } else {
            edit(student);
        }

        response.sendRedirect("/admin/viewStudents");
    }

    private void add(Student student) throws SQLException {

        controller.addStudentToDatabase(student);
    }

    private void edit(Student student) throws SQLException {

        controller.editStudentInDatabase(student);
    }

    private void redirectToAddOrEditStudentJsp(Student student) throws ServletException, IOException {

        request.setAttribute("student", student);
        RequestDispatcher view = request.getRequestDispatcher("/JSP/addOrEditStudent.jsp");
        view.forward(request, response);
    }
}


   