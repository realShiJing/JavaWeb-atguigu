package yang.mybatis.dao.customer;

import yang.mybatis.domain.Customer;

import java.util.List;

/**
 * Created by yangshijing on 2017/11/18 0018.
 */
public  interface   CustomerDao {
    /**
     * 返回满足查询条件的 List
     * @return
     */
    /*public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);*/

    public List<Customer> getAll();

    public void save(Customer customer);

    public Customer get(Integer id);

    public void delete(Integer id);

    public void update(Customer customer);

    public List<Customer> likeGet(Customer customer);
    /**
     * 返回和 name 相等的记录数.
     * @param name
     * @return
     */
    public long getCountWithName(String name);

}
