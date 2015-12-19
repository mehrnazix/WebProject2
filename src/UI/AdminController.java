package UI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;


public class AdminController extends BaseController {

    AdminTeacherManipulate adminTeacherManipulate;
    AdminStudentManipulate adminStudentManipulate;
    AdminCourseManipulate adminCourseManipulate;

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
            adminTeacherManipulate = new AdminTeacherManipulate(Request, Response);
            adminTeacherManipulate.view();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createTeacher() {

        try {
            adminTeacherManipulate.create();

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher() {

        try {
            adminTeacherManipulate.update();

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher() {

        adminTeacherManipulate.delete();
    }

    public void saveTeacher() {

        try {
            adminTeacherManipulate.save();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /******
     * Student
     ******/
    public void viewStudents() {

        try {
            adminStudentManipulate = new AdminStudentManipulate(Request, Response);
            adminStudentManipulate.view();

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

        try {
            adminStudentManipulate.create();

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {

        try {
            adminStudentManipulate.update();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {

        try {
            adminStudentManipulate.delete();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveStudent() {

        try {
            adminStudentManipulate.save();

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
            adminCourseManipulate = new AdminCourseManipulate(Request, Response);
            adminCourseManipulate.view();

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

        try {
            adminCourseManipulate.create();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse() {

        try {
            adminCourseManipulate.update();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse() {

        try {
            adminCourseManipulate.delete();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveCourse() {

        try {
            adminCourseManipulate.save();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
