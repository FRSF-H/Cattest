package com.frsf;
import java.sql.*;
public class mysql {
   private static Connection connection;
   private static Statement statement;
   private static ResultSet rs;
   public static Connection getConnection() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");      //注册驱动
         try {
         String url = "jdbc:mysql://localhost:8080/frsf?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
         String user = "";
         String pass = "";
         connection = DriverManager.getConnection(url, user, pass);     //获取链接
         } catch (SQLException e) {
            e.printStackTrace();
         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      return connection;
   }
   public static void close() throws SQLException {
      if (rs != null)
         rs.close();
      if (statement != null)
         statement.close();
      if (connection != null)
         connection.close();
   }
}
