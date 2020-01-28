package com.ttn.databaseConnection;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class CustomJDBCTemplate{
    JdbcTemplate jdbcTemplate;

    public CustomJDBCTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public void userCount() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }


    public void getUserName() {
        String sql = "SELECT username FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"user"}, String.class));
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO user (username,password,name,age,dob)VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{ user.getUsername(), user.getPassword(), user.getName(),
                user.getAge(), user.getDob() });
    }


    public void queryForMapDemo() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForMap(sql, new Object[] {"user"}));
    }


    public void queryForListDemo() {
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));

    }

    public void getUser() {
        String sql = "SELECT * FROM user WHERE username = ?";
        System.out.println(jdbcTemplate.queryForObject(sql, new Object[]{"user"}, new UserMapper()));
    }

}