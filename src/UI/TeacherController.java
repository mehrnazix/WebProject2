package UI;

import Biz.Controller;
import Biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class TeacherController extends BaseController {

    Controller controller;

    public void index() {

        try {
            controller = new Controller();
            RequestDispatcher view = Request.getRequestDispatcher("/JSP/teacherPage.jsp");
            view.forward(Request, Response);
//            Response.sendRedirect("/JSP/teacherPage.jsp");

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
            Teacher teacher = controller.loadTeacherByUserId(userId);
            Request.setAttribute("teacher", teacher);
            Request.getRequestDispatcher("/JSP/profileTeacher.jsp").forward(Request, Response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }


    }

}
