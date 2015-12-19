package UI;

import Biz.Controller;
import Biz.Class;
import Biz.Teacher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by 931664 on 12/6/2015.
 */
@WebServlet(name = "ClassController")
public class ClassController extends BaseController {

    Controller controller;

    /*main page: use in url*/
    public void index() {
        try {
            controller = new Controller();
            List<Class> classes = controller.loadAllClasses();

            HttpSession session = Request.getSession();
            session.setAttribute("classList", classes);

            RequestDispatcher view = Request.getRequestDispatcher("/JSP/viewClasses.jsp");
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

    /*create new class: use in url*/
    public void create() throws ServletException, IOException {

        try {
            dispatchToAddOrEditClassJsp(new Class());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*update selected class: use in url*/
    public void update() {

        Integer classId = (int) Request.getAttribute("id");

        try {
            Class cls = controller.loadClass(classId);
            dispatchToAddOrEditClassJsp(cls);

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

    public void delete() throws IOException {

        Integer classId = (int) Request.getAttribute("id");

        try {
            controller.deleteClassFromDatabase(classId);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Response.sendRedirect("/class");
    }

    public void save() throws IOException, ServletException {

        Integer classId = Integer.parseInt(Request.getParameter("id"));
        Integer teacherId = Integer.parseInt(Request.getParameter("teacherId"));
        Integer courseId = Integer.parseInt(Request.getParameter("courseId"));
        String classNumber = Request.getParameter("classNumber");
        String classDateTime = Request.getParameter("[ClassDateTime]");

        Class cls = new Class(classId, teacherId, courseId, classNumber, classDateTime);

        if (classId == 0) {
            add(cls);
        } else {
            edit(cls);
        }

        Response.sendRedirect("/class");
    }

    private void add(Class cls) throws IOException, ServletException {

        try {
            controller.addClassToDatabase(cls);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void edit(Class cls) {

        try {
            controller.editClassInDatabase(cls);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dispatchToAddOrEditClassJsp(Class cls) throws ServletException, IOException, SQLException, ClassNotFoundException {

        List<Teacher> teachers = controller.loadTeachers();

        Request.setAttribute("class", cls);
        Request.setAttribute("teachers", teachers);

        RequestDispatcher view = Request.getRequestDispatcher("/JSP/addOrEditClass.jsp");
        view.forward(Request, Response);
    }
}
