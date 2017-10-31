package yang.mybatis.dao;

import org.springframework.stereotype.Component;
import yang.mybatis.domain.User;

public interface UserDao {
	public User findUserById(int id ) throws Exception;
	
	public int insertUser(User user) throws Exception;
}
