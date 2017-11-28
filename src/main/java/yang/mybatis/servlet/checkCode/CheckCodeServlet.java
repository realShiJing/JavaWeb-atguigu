package yang.mybatis.servlet.checkCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/23 0023.
 */
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String  check_code_key = (String)session.getAttribute("CHECK_CODE_KEY");
        String checkCode = request.getParameter("checkCode");
        //不区分大小写
        if(check_code_key != null && !check_code_key.trim().equals("")){
            check_code_key = check_code_key.toLowerCase();
        }
        if (checkCode != null && !checkCode.trim().equals("")){
            checkCode = checkCode.toLowerCase();
        }
        //验证码为NULL或者两者不等，重定向到信息提示页面
        if(check_code_key == null || checkCode == null && !check_code_key.equals(checkCode)){
            request.getSession().setAttribute("MessageIfo","验证不一致");
            response.sendRedirect(request.getContextPath()+"/jsp/checkCode/index.jsp");
            return;
        }
        //如果两个验证码一致，处理该表单请求,并移除sesssion域中的属性值
        session.removeAttribute("CHECK_CODE_KEY");
        response.sendRedirect(request.getContextPath()+"/jsp/token/success.jsp");
    }
}
