package UI;

import Biz.*;
import Biz.Course.Course;
import Biz.Course.CourseBLO;
import Biz.StudentCourseMark;
import Biz.Student.Student;
import Biz.Student.StudentBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentController extends BaseController {

    StudentBLO studentBLO;
    ChangePasswordBLO changePasswordBLO;
    CourseBLO courseBLO;

    public void index() {

        try {

            if (studentBLO == null) {
                studentBLO = new StudentBLO();
            }

            HttpSession session = Request.getSession();

            if (session.getAttribute("student") == null) {

                int userId = (int) session.getAttribute("userId");
                Student student = studentBLO.loadByUserId(userId);
                session.setAttribute("student", student);
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
            index();

        try {
            Request.getRequestDispatcher("/JSP/studentProfile.jsp").forward(Request, Response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    public void transcripts() {

        try {
            if (studentBLO == null)
                index();

            Student student = (Student) Request.getSession().getAttribute("student");
            List<StudentCourseMark> transcripts = studentBLO.loadCoursesOfStudentByStudentId(student.getStudentId());
            Request.getSession().setAttribute("transcripts", transcripts);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/studentTranscripts.jsp");
            view.forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void chooseCourses() {

        try {
            if (studentBLO == null)
                index();

            Student student = (Student) Request.getSession().getAttribute("student");
            List<StudentCourseMark> courseListOfStudent = studentBLO.loadCoursesOfStudentByStudentId(student.getStudentId());
            Request.getSession().setAttribute("courseListOfStudent", courseListOfStudent);
            Request.getRequestDispatcher("/JSP/studentChooseCourses.jsp").forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectCourse() {

        try {
            if (studentBLO == null)
                index();

            if (courseBLO == null)
                courseBLO = new CourseBLO();

            List<Course> courseList = courseBLO.loadList();
            Request.setAttribute("courseList", courseList);
            Request.getRequestDispatcher("/JSP/viewCoursesForStudent.jsp").forward(Request, Response);

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

    public void addStudentCourse() {

        if (studentBLO == null)
            index();

        int courseId = (int) Request.getAttribute("id");
        Student student = (Student) Request.getSession().getAttribute("student");

        try {
            studentBLO.giveUpCourse(courseId, student.getStudentId());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        chooseCourses();
    }

    public void deleteCourse() {

        if (studentBLO == null)
            index();

        int studentCourseId = (int) Request.getAttribute("id");

        try {
            studentBLO.deleteStudentCourse(studentCourseId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        chooseCourses();
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
