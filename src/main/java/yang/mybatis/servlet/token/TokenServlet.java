package yang.mybatis.servlet.token;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/22 0022.
 */
public class TokenServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //模仿后台延时
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     /*   HttpSession session = request.getSession();
        //从Session域中获得标识
        String token = (String)session.getAttribute("token");
        //从表单隐藏域中获取token value
        String tokenValue = request.getParameter("tokenValue");
        //如果标识不为空且隐藏域中值和Session域中的值一致，则处理该表单请求
        if(token != null && tokenValue.equals(token)){
            session.removeAttribute("token");
        }else{
            response.sendRedirect(request.getContextPath()+"/jsp/token/token.jsp");
            return;
        }
        request.getRequestDispatcher("/jsp/token/success.jsp").forward(request,response);*/
        boolean tokenValid = TokenProcessor.getInstance().isTokenValid(request);
        //如果不是重复的表单请求，移除token并处理请求
        if(tokenValid){
            TokenProcessor.getInstance().resetToken(request);
        }else {
            //重复的表单请求，结束方法，并重定向到提示页面
            response.sendRedirect(request.getContextPath()+"/jsp/token/token.jsp");
            return;
        }
        response.sendRedirect(request.getContextPath()+"/jsp/token/success.jsp");
    }
}
