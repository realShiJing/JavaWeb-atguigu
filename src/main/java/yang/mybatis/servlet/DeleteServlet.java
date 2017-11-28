package yang.mybatis.servlet;

import yang.mybatis.dao.UserDaoTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yangshijing on 2017/11/10 0010.
 */
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDaoTest userDaoTest = new UserDaoTest();
        userDaoTest.deleteById(Integer.parseInt(id));
        request.getRequestDispatcher("/listAllStudent").forward(request,response);
    }
}
