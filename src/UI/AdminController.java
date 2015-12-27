package UI;

import Biz.Course.Course;
import Biz.Course.CourseBLO;
import Biz.Student.Student;
import Biz.Student.StudentBLO;
import Biz.Teacher.Teacher;
import Biz.Teacher.TeacherBLO;
import Biz.User.User;

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
            Teacher teacher = teacherBLO.loadByTeacherId(teacherId);
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

        User user = new User(userId, firstName, lastName, nationalCode, teacherCode, email,
                phoneNumber, mobileNumber, address, 2);

        return new Teacher(teacherId, user);
    }

    /******
     * Student
     ******/
    public void viewStudents() {

        try {

            if (studentBLO == null) {
                studentBLO = new StudentBLO();
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
            redirectToAddOrEditStudentJsp(new Student());

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
            int studentId = (int) Request.getAttribute("id");
            Student student = studentBLO.loadByStudentId(studentId);
            redirectToAddOrEditStudentJsp(student);

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
            int studentId = (int) Request.getAttribute("id");
            studentBLO.delete(studentId);
            Response.sendRedirect("/admin/viewStudents");

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
            Student student = newStudent();
            studentBLO.save(student);
            Response.sendRedirect("/admin/viewStudents");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void redirectToAddOrEditStudentJsp(Student student) throws ServletException, IOException {

        Request.setAttribute("student", student);
        RequestDispatcher view = Request.getRequestDispatcher("/JSP/addOrEditStudent.jsp");
        view.forward(Request, Response);
    }

    private Student newStudent() {

        int studentId = Integer.parseInt(Request.getParameter("studentId"));
        int userId = Integer.parseInt(Request.getParameter("userId"));
        String firstName = Request.getParameter("firstName");
        String lastName = Request.getParameter("lastName");
        Integer nationalCode = Integer.parseInt(Request.getParameter("nationalCode"));
        Integer studentCode = Integer.parseInt(Request.getParameter("code"));
        String email = Request.getParameter("email");
        Integer phoneNumber = Integer.parseInt(Request.getParameter("phoneNumber"));
        Integer mobileNumber = Integer.parseInt(Request.getParameter("mobileNumber"));
        String address = Request.getParameter("address");

        User user = new User(userId, firstName, lastName, nationalCode, studentCode, email,
                phoneNumber, mobileNumber, address, 3);

        return new Student(studentId, user);
    }

    /******
     * Course
     ******/
    public void viewCourses() {

        try {

            if (courseBLO == null) {
                courseBLO = new CourseBLO();
            }

            List<Course> courses = courseBLO.loadList();
            HttpSession session = Request.getSession();
            session.setAttribute("courseList", courses);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewCourses.jsp");
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

    public void createCourse() {

        if (courseBLO == null) {
            viewCourses();
        }

        try {
            directToAddOrEditCourseJsp(new Course());

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
            int courseId = (int) Request.getAttribute("id");
            Course course = courseBLO.loadByCourseId(courseId);
            directToAddOrEditCourseJsp(course);

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
            int courseId = (int) Request.getAttribute("id");
            courseBLO.delete(courseId);
            Response.sendRedirect("/admin/viewCourses");

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
            Course course = newCourse();
            courseBLO.save(course);
            Response.sendRedirect("/admin/viewCourses");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Course newCourse() {
        Integer courseId = Integer.parseInt(Request.getParameter("id"));
        String courseName = Request.getParameter("name");
        Integer courseCode = Integer.parseInt(Request.getParameter("code"));
        Integer coefficient = Integer.parseInt(Request.getParameter("coefficient"));
        Integer courseTeacherId = Integer.parseInt(Request.getParameter("teacherId"));


        return new Course(courseId, courseName, courseCode, coefficient, courseTeacherId);
    }

    private void directToAddOrEditCourseJsp(Course course) throws SQLException, ServletException, IOException {

        List<Teacher> teachers = courseBLO.loadTeacherList();

        Request.setAttribute("course", course);
        Request.setAttribute("teachers", teachers);

        RequestDispatcher view = Request.getRequestDispatcher("/JSP/addOrEditCourse.jsp");
        view.forward(Request, Response);
    }

}
