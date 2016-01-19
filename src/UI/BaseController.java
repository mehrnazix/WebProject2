package UI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseController extends HttpServlet {

    protected HttpServletRequest Request;
    protected HttpServletResponse Response;
    protected String[] RouteData;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Request = request;
        Response = response;


        callAction();
    }

    private void callAction() {

        String host = "http://" + Request.getHeader("host");
        String url = Request.getRequestURI().replace(host, "");
        RouteData = url.split("/");

        String actionName = "";
        Integer entityId = 0;

        if (RouteData.length > 2) {
            actionName = RouteData[2];
            if (RouteData.length > 3) {
                entityId = Integer.parseInt(RouteData[3]);
                Request.setAttribute("id", entityId);
            }
        } else {
            actionName = "Index";
        }


        try {
            Method actionMethod = this.getClass().getMethod(actionName, null);
            actionMethod.invoke(this, null);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
