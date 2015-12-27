package UI;


import Biz.User.User;
import Biz.User.UserBLO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by 931664 on 12/26/2015.
 */
@WebServlet(name = "loginFilter")
public class LoginFilter implements Filter {

    private FilterConfig fc;
    UserBLO userBLO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String url = null;


        if (userBLO == null) {

            try {
                userBLO = new UserBLO();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        User currentUser = null;
        try {
            currentUser = userBLO.loadByUsernameAndPassword(userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

            request.getSession().setAttribute("user", currentUser);
            request.getSession().setAttribute("userId", currentUser.getUserId());

        } else {

            url = "/HTML/Index.html";
        }

        response.sendRedirect(url);


    }

    @Override
    public void destroy() {

    }
}
