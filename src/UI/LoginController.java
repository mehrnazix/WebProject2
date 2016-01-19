package UI;

import Biz.User.User;
import Biz.User.UserBLO;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 931664 on 12/13/2015.
 */


@WebServlet(name = "LoginController")
public class LoginController extends BaseController {

    UserBLO userBLO;

    public void login() {

        String userName = Request.getParameter("userName");
        String password = Request.getParameter("password");
        String url = null;

        try {

            if (userBLO == null) {

                userBLO = new UserBLO();
            }
            User currentUser = userBLO.loadByUsernameAndPassword(userName, password);

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
                    Request.getSession().setAttribute("user", currentUser);
                    Request.getSession().setAttribute("userId", currentUser.getUserId());
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

    public void logout() {

        HttpSession session = Request.getSession(false);
        if (session != null) {

            session.removeAttribute("user");
            session.invalidate();
        }

        try {
            Request.getRequestDispatcher("/HTML/Index.html").forward(Request, Response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
