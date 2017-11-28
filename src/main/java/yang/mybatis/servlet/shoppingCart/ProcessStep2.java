package yang.mybatis.servlet.shoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/22 0022.
 */
public class ProcessStep2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String paytype = request.getParameter("paytype");
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("address",address);
        request.getSession().setAttribute("paytype",paytype);
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/jsp/shoppingcart/step3.jsp");
    }
}
