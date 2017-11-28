package yang.mybatis.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yangshijing on 2017/11/27 0027.
 */
public class LoginFilter implements Filter {
    private  String sessionKey;
    private  String redictUrl;
    private  String uncheckUrl;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        sessionKey = filterConfig.getServletContext().getInitParameter("sessionKey");
        redictUrl = filterConfig .getServletContext().getInitParameter("redictUrl");
        uncheckUrl = filterConfig.getServletContext().getInitParameter("uncheckedUrl");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //请求的Url是否包含在web应用配置的不检查url中,如果包含，则放行，结束该方法
        HttpServletRequest request= (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;








        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        String servletPath = request.getServletPath();












        List<String> uncheckUrls = Arrays.asList(uncheckUrl.split(","));
        if(uncheckUrls.contains(servletPath)){
            filterChain.doFilter(request,response);
            return;
        }
        //从session中获取user,为null，则进行拦截,重定向到redictUrl
        Object user = request.getSession().getAttribute(sessionKey);
        if(user == null){
            response.sendRedirect(request.getContextPath()+redictUrl);
        }else {
            filterChain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {

    }
}
