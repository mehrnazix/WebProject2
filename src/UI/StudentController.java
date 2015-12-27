package UI;

import Biz.*;
import Biz.Course.Course;
import Biz.Student.Student;
import Biz.Student.StudentBLO;
import Biz.Teacher.Teacher;
import Biz.User.UserBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentController extends BaseController {

    StudentBLO studentBLO;
    ChangePasswordBLO changePasswordBLO;

    public void index() {

        try {

            if (studentBLO == null) {
                studentBLO = new StudentBLO();
            }

            int userId = (int) Request.getSession().getAttribute("userId");
            Student student = studentBLO.loadByUserId(userId);

            Request.getSession().setAttribute("studentId", student.getStudentId());
            Request.setAttribute("student", student);

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
            index();

        try {
            Request.getRequestDispatcher("/JSP/profileStudent.jsp").forward(Request, Response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

//    public void viewGrades() {
//        try {
//            Response.sendRedirect("/grade/gradesOfStudent");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteGrade() {
//        try {
//            int gradeId = (int) Request.getAttribute("id");
//            Request.getRequestDispatcher("/grade/delete/" + gradeId).forward(Request, Response);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//
//        viewGrades();
//    }

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
        index();
    }

}
