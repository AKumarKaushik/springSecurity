package com.ttn.Spring_jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Spring_jdbc{

    public static DataSource dataSource;

    public Spring_jdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void preparedStatement() throws Exception {
        PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from user");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));
        }
    }
}
