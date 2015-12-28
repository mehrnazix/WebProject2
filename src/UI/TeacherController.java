package UI;

import Biz.ChangePasswordBLO;
import Biz.StudentCourseMark;
import Biz.Teacher.Teacher;
import Biz.Teacher.TeacherBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TeacherController extends BaseController {

    TeacherBLO teacherBLO;
    ChangePasswordBLO changePasswordBLO;

    public void index() {

        try {
            if (teacherBLO == null) {

                teacherBLO = new TeacherBLO();
            }


            int userId = (int) Request.getSession().getAttribute("userId");
            Teacher teacher = teacherBLO.loadByUserId(userId);

            Request.getSession().setAttribute("teacherId", teacher.getTeacherId());
            Request.setAttribute("teacher", teacher);

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
            index();

        int userId = (int) Request.getSession().getAttribute("user");

        try {
            Teacher teacher = teacherBLO.loadByUserId(userId);
            Request.setAttribute("teacher", teacher);
            Request.getRequestDispatcher("/JSP/profileTeacher.jsp").forward(Request, Response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void grades() {
        try {

            if (teacherBLO == null)
                index();

            int teacherId = (int) Request.getSession().getAttribute("teacherId");
            List<StudentCourseMark> gradeList = teacherBLO.loadStudentCourseListByTeacherId(teacherId);

            HttpSession session = Request.getSession();
            session.setAttribute("gradeList", gradeList);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/teacherGrades.jsp");
            view.forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void giveUpScore() {

        try {
            if (teacherBLO == null)
                index();

            int gradeId = (int) Request.getAttribute("id");
//            StudentCourseMark grade = teacherBLO.loadStudentCourseByTeacherId(gradeId);

//            HttpSession session = Request.getSession();
//            session.setAttribute("grade", grade);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewGrade.jsp");
            view.forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGrade() {

        try {

            if (teacherBLO == null)
                index();

            int gradeId = (int) Request.getAttribute("id");
            int score = Integer.parseInt(Request.getParameter("score"));

            teacherBLO.updateScore(gradeId, score);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        grades();
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
        index();
    }

}
