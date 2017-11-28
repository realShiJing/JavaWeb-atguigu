package yang.mybatis.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by yangshijing on 2017/11/18 0018.
 */
public class JdbcUtils {

    private static DataSource dataSource = null;

    static{
        //数据源只能被创建一次.
        dataSource = new ComboPooledDataSource("mvcapp");
    }
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void releaseConnection(Connection connection) {
        try {
            if(connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
