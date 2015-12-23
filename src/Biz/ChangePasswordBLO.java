package Biz;

import Biz.User.User;
import Biz.User.UserBLO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by 931664 on 12/22/2015.
 */
public class ChangePasswordBLO {

    UserBLO userBLO;
    HttpServletRequest request;
    HttpServletResponse response;

    public ChangePasswordBLO(HttpServletRequest req, HttpServletResponse res) throws SQLException, ClassNotFoundException {

        request = req;
        response = res;
        userBLO = new UserBLO();
    }

    public void view() {

        User user = (User) request.getSession().getAttribute("user");

        try {
//            User user = userBLO.loadByUserId(userId);
            request.setAttribute("user", user);

            RequestDispatcher view = request.getRequestDispatcher("/JSP/changePassword.jsp");
            view.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {

        int userId = Integer.parseInt(request.getParameter("userId"));
        String newPassword = request.getParameter("newPassword");
        User user = new User(userId, newPassword);

        try {
            userBLO.updatePassword(user);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
