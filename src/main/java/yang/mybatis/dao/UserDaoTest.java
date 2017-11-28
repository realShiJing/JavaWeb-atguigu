package yang.mybatis.dao;

import yang.mybatis.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangshijing on 2017/11/10 0010.
 */
public class UserDaoTest {
    /**
     * 获取用户信息
     * JDBC方式
     * @return
     */
    public List<User> getAll(){

        List<User> Users = new ArrayList<User>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///mydb";
            String user = "root";
            String pass= "1234";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT user_name, id, age, password FROM myuser";
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String user_name = resultSet.getString(1);
                int id = resultSet.getInt(2);
                int age = resultSet.getInt(3);
                String password = resultSet.getString(4);
                User userl= new User(user_name,id,age,password);
                Users.add(userl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(resultSet != null){
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Users;
    }

    public void deleteById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String driverClass = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql:///mydb";
            String user = "root";
            String pass= "1234";

            Class.forName(driverClass);
            connection = DriverManager.getConnection(url, user, pass);

            String sql = "DELETE FROM myuser WHERE id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int i = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
