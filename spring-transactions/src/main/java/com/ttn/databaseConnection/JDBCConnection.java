package com.ttn.databaseConnection;

import java.sql.*;
import com.mysql.jdbc.Driver;
import java.util.Properties;

public class JDBCConnection {
    public static void main(String[] args) throws Exception{
        preparedStatement();
    }
    private static Connection getConnection1() throws Exception {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String connectionString = "jdbc:mysql://localhost:3306/spring_demo";
            return DriverManager.getConnection(connectionString, "root", "igdefault");
        }

    private static void preparedStatement() throws Exception {
        PreparedStatement ps =getConnection1().prepareStatement("select * from user");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        }
    }

    private static Connection getConnection2() throws Exception{
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String connectionString = "jdbc:mysql://localhost:3306/spring_demo";
        return DriverManager.getConnection(connectionString, "root", "igdefault");
    }

    private static Connection getConnection3() throws Exception{
        java.sql.Driver driver = new com.mysql.jdbc.Driver();
        Properties dbProp = new Properties();
        dbProp.put("user","root");
        dbProp.put("password","igdefault");
        return driver.connect("jdbc:mysql://localhost:3306/spring_demo",dbProp);
    }

    private static Connection getConnection4()throws Exception{
        System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
        Properties dbProp=new Properties();
        dbProp.put("user","root");
        dbProp.put("password","igdefault");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_demo",dbProp);
    }
}
