package com.myproject.dao;

import com.myproject.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        // TODO 自动生成的方法存根
        return new User(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("dept"),
                rs.getString("phone"),
                rs.getString("website"),
                rs.getDate("birthday")
        );
    }
}
