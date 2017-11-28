package yang.mybatis.test;

import org.junit.Test;
import yang.mybatis.dao.customer.CustomerDao;
import yang.mybatis.dao.customer.CustomerDaoImp;
import yang.mybatis.domain.Customer;

import java.util.List;

/**
 * Created by yangshijing on 2017/11/18 0018.
 */
public class CustomerDaoImpTest {

    CustomerDao customerDao = new CustomerDaoImp();
    @Test
    public void testGetAll() {
        List<Customer> customers = customerDao.getAll();
        System.out.println(customers);
    }
    @Test
    public void testSave() {
        Customer customer = new Customer();
        customer.setName("HIII");
        customer.setAddress("HENAM");
        customer.setPhone("");
        customerDao.save(customer);
    }

    @Test
    public void testGet() {
        Customer customer = customerDao.get(4);
        System.out.print(customer);
    }

    @Test
    public void testDelete() {
        customerDao.delete(4);;
    }

    @Test
    public void testUpdate() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("fdsaf");
        customer.setAddress("Shangqiu");
        customer.setPhone("");
        customerDao.update(customer);
    }

    @Test
    public void testGetCount() {

        long count = customerDao.getCountWithName("HIII");
        System.out.print(count);
    }
    @Test
    public void testLike() {
        Customer customer = new Customer();
        customer.setName("f");
        customer.setAddress("Shangqiu");
        customer.setPhone("");
        List<Customer> customers = customerDao.likeGet(customer);
        System.out.print(customers);
    }
}
