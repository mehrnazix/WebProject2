package UI;

import Biz.*;
import Biz.Student.Student;
import Biz.Student.StudentBLO;
import Biz.User.UserBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class StudentController extends BaseController {

    StudentBLO studentBLO;
    ChangePasswordBLO changePasswordBLO;
    UserBLO userBLO;

    public void Index() {

        try {

            if (studentBLO == null) {
                studentBLO = new StudentBLO();
            }

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/studentPage.jsp");
            view.forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void profile() {

        if (studentBLO == null)
            Index();

        int userId = (int) Request.getSession().getAttribute("userId");

        try {
            Student student = studentBLO.loadByUserId(userId);
            Request.setAttribute("student", student);
            Request.getRequestDispatcher("/JSP/profileStudent.jsp").forward(Request, Response);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void changePassword() {

        if (changePasswordBLO == null) {
            try {
                changePasswordBLO = new ChangePasswordBLO(Request, Response);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        changePasswordBLO.view();
    }

    public void saveChangePassword() {

        if (changePasswordBLO == null) {
            try {
                changePasswordBLO = new ChangePasswordBLO(Request, Response);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        changePasswordBLO.save();
        Index();
    }

}
