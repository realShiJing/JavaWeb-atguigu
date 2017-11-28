package yang.mybatis.servlet.shoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/22 0022.
 */
public class ProcessStep1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取选中的图书的信息
        String[] books = request.getParameterValues("book");
        //2.把图书信息放入到Seesion中
        request.getSession().setAttribute("books",books);
        //3.重定向到shoppingcart/step2.jsp
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/jsp/shoppingcart/step2.jsp");

    }
}
