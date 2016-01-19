package UI;

import Biz.ChangePasswordBLO;
import Biz.Teacher.Teacher;
import Biz.Teacher.TeacherBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class TeacherController extends BaseController {

    TeacherBLO teacherBLO;
    ChangePasswordBLO changePasswordBLO;

    public void Index() {

        try {
            if (teacherBLO == null) {

                teacherBLO = new TeacherBLO();
            }

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/teacherPage.jsp");
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

        if (teacherBLO == null)
            Index();

        int userId = (int) Request.getSession().getAttribute("user");

        try {
            Teacher teacher = teacherBLO.loadByUserId(userId);
            Request.setAttribute("teacher",teacher);
            Request.getRequestDispatcher("/JSP/profileTeacher.jsp").forward(Request, Response);

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
