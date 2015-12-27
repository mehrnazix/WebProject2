package UI;

import Biz.Course.Course;
import Biz.Course.CourseBLO;
import Biz.Grade;
import Biz.GradeBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GradeController extends BaseController {

    GradeBLO gradeBLO;
    CourseBLO courseBLO;

    public void gradesOfStudent() {

        try {

            if (gradeBLO == null) {
                gradeBLO = new GradeBLO();
            }

            int studentId = (int) Request.getSession().getAttribute("studentId");
            List<Grade> gradeList = gradeBLO.loadListByStudentId(studentId);

            HttpSession session = Request.getSession();
            session.setAttribute("gradeList", gradeList);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewGradesOfStudent.jsp");
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

    public void gradesOfTeacher() {

        try {

            if (gradeBLO == null) {
                gradeBLO = new GradeBLO();
            }

            int teacherId = (int) Request.getSession().getAttribute("teacherId");
            List<Grade> gradeList = gradeBLO.loadListByTeacherId(teacherId);

            HttpSession session = Request.getSession();
            session.setAttribute("gradeList", gradeList);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewGradesOTeacher.jsp");
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

    public void add() {

        if (gradeBLO == null) {
            return;
        }

        if (courseBLO == null) {
            try {
                courseBLO = new CourseBLO();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            List<Course> courseList = courseBLO.loadList();
            Request.setAttribute("courseList", courseList);
            Request.getRequestDispatcher("/JSP/viewCoursesForGrade.jsp").forward(Request, Response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create() {

        if (gradeBLO == null) {
            return;
        }

        int courseId = (int) Request.getAttribute("id");
        int studentId = (int) Request.getSession().getAttribute("studentId");

        try {
            gradeBLO.add(courseId, studentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        gradesOfStudent();
    }

    public void delete() {

        if (gradeBLO == null) {
            return;
        }

        int gradeId = (int) Request.getAttribute("id");

        try {
            gradeBLO.delete(gradeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (gradeBLO == null) {
            return;
        }

        int gradeId = (int) Request.getAttribute("id");
        int score = Integer.parseInt(Request.getParameter("score"));

        try {
            gradeBLO.update(gradeId, score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save() {

        if (gradeBLO == null) {
            return;
        }

        int gradeId = (int) Request.getAttribute("id");
        int score = Integer.parseInt(Request.getParameter("score"));

        try {
            gradeBLO.update(gradeId, score);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
