package yang.mybatis.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import yang.mybatis.dao.UserDaoImp;
import yang.mybatis.dao.UserDaoTest;
import yang.mybatis.domain.User;

import java.io.IOException;
import java.util.List;

/**
 * JDBC按用户ID从数据库删除用户
 * Created by yangshijing on 2017/11/10 0010.
 */
@Controller
public class ListAllStudent extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            UserDaoTest userDaoTest = new UserDaoTest();
            List<User> list = userDaoTest.getAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("/jsp/hello1.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
