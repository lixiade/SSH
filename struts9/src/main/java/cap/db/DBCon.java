package cap.db;

import java.sql.*;

public class DBCon {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/cap?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private String user = "root";
    private String password = "637315";
    private Connection connection = null;

    public Connection getConnection() {   //控制数据库连接
        try {
            Class.forName(driver);//加载数据库驱动
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public ResultSet doQuery(String sql, Object[] params) {  //控制查询
        ResultSet resultSet = null;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return resultSet;
    }

    public int doUpdate(String sql, Object[] params) {   //控制增删改
        int reslut = 0;
        try {
            connection = this.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            reslut = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return reslut;
    }

    public void close() {   //控制数据库的关闭
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

