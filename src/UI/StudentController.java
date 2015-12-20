package UI;

import Biz.Controller;
import Biz.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class StudentController extends BaseController {

    Controller controller;

    public void index() {

        try {
            controller = new Controller();
            RequestDispatcher view = Request.getRequestDispatcher("/JSP/studentPage.jsp");
            view.forward(Request, Response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profile() {

        int userId = (int) Request.getSession().getAttribute("userId");

        try {
            Student student = controller.loadStudentByUserId(userId);
            Request.setAttribute("student", student);
            Request.getRequestDispatcher("/JSP/profileStudent.jsp").forward(Request, Response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

}
