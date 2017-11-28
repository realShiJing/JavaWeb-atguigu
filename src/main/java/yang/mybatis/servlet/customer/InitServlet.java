package yang.mybatis.servlet.customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by yangshijing on 2017/11/19 0019.
 */
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/classes/switch.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            String type = properties.getProperty("type");
            System.out.print(type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
