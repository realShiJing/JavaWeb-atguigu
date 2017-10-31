package yang.mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import yang.mybatis.domain.User;

/**
 * Created by root on 2017/8/17 0017.
 */
@Component
public class UserDaoImp implements UserDao {
    /**
     * inject ito this.getSqlSession().
     */
    @Autowired
    @Qualifier("mySqlSession")
    protected SqlSession sqlSession ;


    public User findUserById(int id) throws Exception {
        return sqlSession.selectOne( "yang.mybatis.domain.User.findUserById" ,id);
    }

    public int insertUser(User user) throws Exception {
        return insertUser(user);
    }
}
