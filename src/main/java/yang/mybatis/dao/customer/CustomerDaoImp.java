package yang.mybatis.dao.customer;

import yang.mybatis.domain.Customer;

import java.util.List;

/**
 * Created by yangshijing on 2017/11/18 0018.
 */
public class CustomerDaoImp extends BaseDao<Customer> implements CustomerDao{

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT id, name, address, phone FROM customer";
        List<Customer> customers = getForList(sql);
        return customers;
    }

    @Override
    public void save(Customer customer) {
        String sql = "insert into customer (name,address,phone) values (?,?,?)";
        update(sql,customer.getName(),customer.getAddress(),customer.getPhone());
    }

    @Override
    public Customer get(Integer id) {
        String sql = "select * from customer where id=?";
        Customer customer = get(sql,id);
        return customer;
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from customer where id=?";
        update(sql,id);
    }

    @Override
    public void update(Customer customer) {
        String sql = "update customer set name =?,phone = ?,address =? where id =?";
        update(sql,customer.getName(),customer.getPhone(),customer.getAddress(),customer.getId());
    }

    @Override
    public List<Customer> likeGet(Customer customer) {
        String sql = "SELECT id, name, address, phone FROM customer where name like ? and address like ? and phone like ? ";
        List<Customer> customers = getForList(sql,"%"+customer.getName()+"%","%"+customer.getAddress()+"%","%"+customer.getPhone()+"%");
        return customers;
    }

    @Override
    public long getCountWithName(String name) {
        String sql = "select count(*) from customer where name = ?";
        Long  count = getForValue(sql, name);
        return count;
    }
}
