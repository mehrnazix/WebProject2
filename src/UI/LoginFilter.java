package UI;


import Biz.User.User;
import Biz.User.UserBLO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by 931664 on 12/26/2015.
 */
@WebServlet(name = "loginFilter")
public class LoginFilter implements Filter {

    private FilterConfig fc;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        fc = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

        if (session == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("HTML/Index.html");
        }

        User user = (User) session.getAttribute("user");

        if (user == null) {
            ((HttpServletResponse) servletResponse).sendRedirect("HTML/Index.html");
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
