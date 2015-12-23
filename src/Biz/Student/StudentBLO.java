package Biz.Student;

import Biz.Student.Student;
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
    HttpServletRequest request;
    HttpServletResponse response;

    public StudentBLO() {

    }

    public StudentBLO(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        request = req;
        response = res;
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

    public void create() throws ServletException, IOException {

        redirectToAddOrEditStudentJsp(new Student());
    }

    public void update() throws SQLException, ServletException, IOException {

        int studentId = (int) request.getAttribute("id");
        Student student = studentDAO.loadByStudentId(studentId);
        redirectToAddOrEditStudentJsp(student);
    }

    public void delete() throws IOException, SQLException {

        int studentId = (int) request.getAttribute("id");
        studentDAO.delete(studentId);
        response.sendRedirect("/admin/viewStudents");
    }

    public void save() throws SQLException, IOException {

        Student student = newStudent();

        if (student.getStudentId() == 0) {
            add(student);

        } else {
            edit(student);

        }

        response.sendRedirect("/admin/viewStudents");
    }

    private Student newStudent() {

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

        return new Student(userId, studentId, firstName, lastName, nationalCode, studentCode, email,
                phoneNumber, mobileNumber, address);
    }

    private void add(Student student) throws SQLException {

        studentDAO.create(student);
    }

    private void edit(Student student) throws SQLException {

        studentDAO.update(student);
    }

    private void redirectToAddOrEditStudentJsp(Student student) throws ServletException, IOException {

        request.setAttribute("student", student);
        RequestDispatcher view = request.getRequestDispatcher("/JSP/addOrEditStudent.jsp");
        view.forward(request, response);
    }
}


   