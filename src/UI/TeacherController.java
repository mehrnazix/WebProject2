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

    public void Index() {

        try {
            if (teacherBLO == null) {
                teacherBLO = new TeacherBLO();
            }

            HttpSession session = Request.getSession();

            if (session.getAttribute("student") == null) {

                int userId = (int) session.getAttribute("userId");
                Teacher teacher = teacherBLO.loadByUserId(userId);
                session.setAttribute("teacher", teacher);
            }

            Request.getRequestDispatcher("/JSP/teacherPage.jsp").forward(Request, Response);

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


        try {
            Request.getRequestDispatcher("/JSP/teacherProfile.jsp").forward(Request, Response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void grades() {
        try {

            if (teacherBLO == null)
                Index();

            Teacher teacher = (Teacher) Request.getSession().getAttribute("teacher");
            List<StudentCourseMark> transcripts = teacherBLO.loadStudentCourseListByTeacherId(teacher.getTeacherId());

            Request.getSession().setAttribute("transcripts", transcripts);

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
                Index();

            int gradeId = (int) Request.getAttribute("id");
            StudentCourseMark transcript = teacherBLO.loadTranscriptOfStudent(gradeId);

            Request.getSession().setAttribute("transcript", transcript);
            Request.getRequestDispatcher("/JSP/teacherGiveUpGrade.jsp").forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveTranscript() {

        try {

            if (teacherBLO == null)
                Index();

            int transcriptId = Integer.parseInt(Request.getParameter("id"));
            int score = Integer.parseInt(Request.getParameter("score"));

            teacherBLO.updateScore(transcriptId, score);

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
        Index();
    }

}
