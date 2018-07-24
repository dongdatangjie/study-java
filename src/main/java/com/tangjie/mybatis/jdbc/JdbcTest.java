package com.tangjie.mybatis.jdbc;



import java.sql.*;

public class JdbcTest {
    public static void main(String args[]){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "700614");
            //定义sql语句
            String sql = "select * from user where username = ?";
            //获取预处理
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"王五");
            //执行预处理
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("id")+"--"+resultSet.getString("username"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
