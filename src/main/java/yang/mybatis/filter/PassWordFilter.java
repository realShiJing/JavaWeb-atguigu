package yang.mybatis.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/26 0026.
 */
public class PassWordFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String contextPassword = filterConfig.getServletContext().getInitParameter("password");
        String password = servletRequest.getParameter("password");
        if(contextPassword != null && password != null && contextPassword.equals(password)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletRequest.getRequestDispatcher("/jsp/testfilter/login.jsp").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
