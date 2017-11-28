package yang.mybatis.test;

import org.junit.Test;
import yang.mybatis.utils.JdbcUtils;

import java.sql.Connection;
public class JdbcUtilsTest {
    @Test
    public void run () throws Exception {

        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
    }
}

