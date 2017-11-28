package yang.mybatis.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yang.mybatis.dao.UserDaoImp;
import yang.mybatis.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserTest {
			@Autowired
			UserDaoImp userDaoImp;

	   
//	    public static void main(String[] args) throws Exception{
	    	/*//创建sqlSessionFactory
	        //mybatis配置文件
	        String resource="SqlMapConfig.xml";
	        //得到配置文件流
	        InputStream inputStream=Resources.getResourceAsStream(resource);
	        //创建会话工厂，传入mybatis的配置文件信息
	        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);

	        SqlSession sqlSession=factory.openSession();
	        //创建UserMapper对象，mybatis自动生成mapper代理对象
	        UserDao userDao = sqlSession.getMapper(UserDao.class);
	        User user = new User("小22",5,12);
	        //调用userMapper的方法
	        int i = userDao.insertUser(user);
	        User user1 = userDao.findUserById(5);
	        System.out.println(user1);
	   */
	        
			/*ApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		    UserDao userDao=(UserDao) applicationContext.getBean("userDao");*/
//	        User user=userDao.findUserById(1);
//	        User user1 = new User("dada",7,12);
//	        int i = userDao.insertUser(user1);
//	        User user2=userDao.findUserById(7);
//	        System.out.println(i+""+user2+""+user);
//
//	    }
	@Test
	public void run () throws Exception {
		/*User user=userDaoImp.findUserById(1);
		System.out.println(user);*/

	}
	@Test
	public void run1 () throws Exception {
		 String str="1234";
		 System.out.println(str.length());
		String [] arry={"4","4","4","4"};
		int i = arry.length;

	}
	}
	
