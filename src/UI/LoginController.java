package UI;

import Biz.Controller;
import Biz.User;


import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 931664 on 12/13/2015.
 */


@WebServlet(name = "LoginController")
public class LoginController extends BaseController {

    Controller controller;

    public void login() {

        String userName = Request.getParameter("userName");
        String password = Request.getParameter("password");
        String url = null;


        try {

            controller = new Controller();
            User currentUser = controller.loadUser(userName, password);

            if (currentUser != null) {

                switch (currentUser.getUserTypeId()) {
                    case 1:
                        url = "/admin";
                        break;
                    case 2:
                        url = "/teacher";
                        break;
                    case 3:
                        url = "/student";
                        break;
                    default:
                        url = "/index";
                }

                try {
                    Response.sendRedirect(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
