package UI;

import Biz.Course.CourseBLO;
import Biz.Student.Student;
import Biz.Student.StudentBLO;
import Biz.Teacher.Teacher;
import Biz.Teacher.TeacherBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AdminController extends BaseController {

    TeacherBLO teacherBLO;
    StudentBLO studentBLO;
    CourseBLO courseBLO;

    /*main page: use in url*/
    public void index() {

        try {
            RequestDispatcher view = Request.getRequestDispatcher("/JSP/adminPage.jsp");
            view.forward(Request, Response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /******
     * Teacher
     ******/
    public void viewTeachers() {

        try {

            if (teacherBLO == null) {
                teacherBLO = new TeacherBLO();
            }
            List<Teacher> teachers = teacherBLO.loadList();

            HttpSession session = Request.getSession();
            session.setAttribute("teacherList", teachers);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewTeachers.jsp");
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

    public void createTeacher() {

        if (teacherBLO == null) {
            viewTeachers();
        }

        try {
            redirectToAddOrEditTeacherJsp(new Teacher());

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher() {

        if (teacherBLO == null) {
            viewTeachers();
        }

        try {
            int teacherId = (int) Request.getAttribute("id");
            Teacher teacher = teacherBLO.update(teacherId);
            redirectToAddOrEditTeacherJsp(teacher);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher() {

        if (teacherBLO == null) {
            viewTeachers();
        }

        try {
            int teacherId = (int) Request.getAttribute("id");
            teacherBLO.delete(teacherId);
            Response.sendRedirect("/admin/viewTeachers");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTeacher() {

        if (teacherBLO == null) {
            viewTeachers();
        }

        try {
            Teacher teacher = newTeacher();
            teacherBLO.save(teacher);

            Response.sendRedirect("/admin/viewTeachers");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void redirectToAddOrEditTeacherJsp(Teacher teacher) throws ServletException, IOException {

        Request.setAttribute("teacher", teacher);
        RequestDispatcher view = Request.getRequestDispatcher("/JSP/addOrEditTeacher.jsp");
        view.forward(Request, Response);

    }

    private Teacher newTeacher() {

        int teacherId = Integer.parseInt(Request.getParameter("teacherId"));
        int userId = Integer.parseInt(Request.getParameter("userId"));
        String firstName = Request.getParameter("firstName");
        String lastName = Request.getParameter("lastName");
        int nationalCode = Integer.parseInt(Request.getParameter("nationalCode"));
        int teacherCode = Integer.parseInt(Request.getParameter("code"));
        String email = Request.getParameter("email");
        int phoneNumber = Integer.parseInt(Request.getParameter("phoneNumber"));
        int mobileNumber = Integer.parseInt(Request.getParameter("mobileNumber"));
        String address = Request.getParameter("address");

        return new Teacher(userId, teacherId, firstName, lastName, nationalCode, teacherCode, email,
                phoneNumber, mobileNumber, address);
    }

    /******
     * Student
     ******/
    public void viewStudents() {

        try {

            if (studentBLO == null) {
                studentBLO = new StudentBLO(Request, Response);
            }

            List<Student> studentList = studentBLO.loadList();


            HttpSession session = Request.getSession();
            session.setAttribute("studentList", studentList);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewStudents.jsp");
            view.forward(Request, Response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createStudent() {

        if (studentBLO == null) {
            viewStudents();
        }

        try {
            studentBLO.create();

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {

        if (studentBLO == null) {
            viewStudents();
        }

        try {
            studentBLO.update();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {

        if (studentBLO == null) {
            viewStudents();
        }

        try {
            studentBLO.delete();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveStudent() {

        if (studentBLO == null) {
            viewStudents();
        }

        try {
            studentBLO.save();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /******
     * Course
     ******/
    public void viewCourses() {

        try {

            if (courseBLO == null) {
                courseBLO = new CourseBLO(Request, Response);
            }

            courseBLO.view();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createCourse() {

        if (courseBLO == null) {
            viewCourses();
        }

        try {
            courseBLO.create();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse() {

        if (courseBLO == null) {
            viewCourses();
        }

        try {
            courseBLO.update();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse() {

        if (courseBLO == null) {
            viewCourses();
        }

        try {
            courseBLO.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCourse() {

        if (courseBLO == null) {
            viewCourses();
        }

        try {
            courseBLO.save();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
