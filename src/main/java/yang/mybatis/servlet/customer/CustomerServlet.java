package yang.mybatis.servlet.customer;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import yang.mybatis.dao.customer.CustomerDao;
import yang.mybatis.dao.customer.CustomerDaoImp;
import yang.mybatis.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by yangshijing on 2017/11/18 0018.
 */
public class CustomerServlet extends HttpServlet {
    CustomerDao customerDao = new CustomerDaoImp();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取servletPath
        String servletPath = request.getServletPath();
        //2.截取最后一个反斜杠和.do的字符串，即方法名
        String methodName = servletPath.substring(servletPath.lastIndexOf('/')+1,servletPath.lastIndexOf('.'));
        try {
            //3.利用反射获取methodName对应的方法
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
                    HttpServletResponse.class);
            //4.利用反射调用methodName对应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/error/error.jsp");
        }
    }
    public void addCustomer(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Customer customer = getInfo(request);
        //检查用户名是否被占用
        long count = customerDao.getCountWithName(customer.getName());
        if(count>0){
            //用户名被占用提示信息
            request.setAttribute("message","该用户名已被占用");
            //回显数据
            request.setAttribute("name",customer.getName());
            request.setAttribute("phone",customer.getPhone());
            request.setAttribute("address",customer.getAddress());
            //回显页面
            request.getRequestDispatcher("/jsp/addCustomer.jsp").forward(request,response);
        }else {
            //用户名没有被占用时，保存数据
            customerDao.save(customer);
            response.sendRedirect("/jsp/query.do");
            //request.getRequestDispatcher("/jsp/query.do").forward(request,response);
        }
    }
    /**
     *  查询所有用户
     *
     */
    public void query(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //从form表单中获取请求参数
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        //判断有无查询条件
        if((name!=null&&name.length()!=0)||(phone!=null&&phone.length()!=0)||(address!=null&&address.length()!=0)){
            //将请求参数封装为JavaBean实体类
            Customer customer = new Customer(name,phone,address);
            //有查询条件时模糊查询
            List<Customer> customers = customerDao.likeGet(customer);
            request.setAttribute("customers", customers);
            //请求转发把数据传入目标页面中
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }else{
            //1.从数据库中查询出全部的用户信息
            List<Customer> customers = customerDao.getAll();
            //2.把Customer集合放入request域对象中
            request.setAttribute("customers", customers);
            //3.请求转发把数据传入目标页面中
            request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        }

    }

    /**
     * 修改客户信息页面
     * @param request
     * @param response
     * @throws IOException
     */
    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //获取要修改的客户的id
        String id = request.getParameter("id");
        if(StringUtils.isNumeric(id)){
            Customer customer = customerDao.get(Integer.parseInt(id));
            request.setAttribute("name",customer.getName());
            request.setAttribute("phone",customer.getPhone());
            request.setAttribute("address",customer.getAddress());
            //将客户的信息传入修改页面，id传入隐藏域，修改用户接口会用到客户id
            request.setAttribute("id",id);
            request.getRequestDispatcher("/jsp/editCustomer.jsp").forward(request,response);
            //没有异常，则结束方法
            return;
        }
        //有异常跳转错误一面
        response.sendRedirect("/error/error.jsp");
    }

    /**
     * 修个客户信息接口
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //用于封装表单提交过来的信息
        Customer customer = null;
        //用于封装从数据库中查询出的信息
        Customer oldCustomer = null;
        //从form表单中获取请求参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        //从数据库中根据id查询客户旧名字
        if(StringUtils.isNumeric(id)){
            oldCustomer = customerDao.get(Integer.parseInt(id));
        }
        //如果没有查询到数据，结束方法，跳转错误提示页面
        if(oldCustomer==null){
            response.sendRedirect("/error/error.jsp");
            return;
        }
        String oldName = oldCustomer.getName();
        //如果新名字和数据库或者能够的名字一样可以修改
        if(oldName.equals(name)){
            if (StringUtils.isNumeric(id)) {
                customer = new Customer(Integer.parseInt(id), name, phone, address);
            }
            if(customer==null){
                response.sendRedirect("/error/error.jsp");
                return;
            }
            customerDao.update(customer);
            response.sendRedirect("/jsp/query.do");
        }else{
            //否则，从数据库中查询新名字在数据库中是否已存在
            long count = customerDao.getCountWithName(name);
            //如果count大于零，则表示用户名已被占用
            if(count>0){
                //用户名被占用提示信息
                request.setAttribute("message","该用户名已被占用");
                //回显数据
                request.setAttribute("id",id);
                request.setAttribute("name",name);
                request.setAttribute("phone",phone);
                request.setAttribute("address",address);
                //回显页面
                request.getRequestDispatcher("/jsp/editCustomer.jsp").forward(request,response);
            }else{
                if (StringUtils.isNumeric(id)) {
                    customer = new Customer(Integer.parseInt(id), name, phone, address);
                }
                if(customer==null){
                    response.sendRedirect("/error/error.jsp");
                    return;
                }
                customerDao.update(customer);
                response.sendRedirect("/jsp/query.do");
            }
        }

    }
    public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        //判断字符串是否为数字字符串
        if(StringUtils.isNumeric(id)){
            customerDao.delete(Integer.parseInt(id));
            response.sendRedirect("/jsp/query.do");
        }

    }

    /**
     * 从表单中获取用户信息
     */
    public Customer getInfo(HttpServletRequest request) {
        //从form表单中获取请求参数
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        Customer customer = new Customer( name, phone, address);
        return customer;

    }

}
