package com.myproject.dao;

import com.myproject.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper
public interface IUserMapper {
    @Select("select * from user where id= #{id}")
    User getUserByID(int id);

    @Insert("insert into user(id,name, dept,phone,website,birthday) values(#{id},#{name}, #{dept},#{phone}, #{website}, #{birthday})")
    int insertUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUserById(int id);

    @Update("update user set name=#{name},dept=#{dept},phone=#{phone},website=#{website},birthday=#{birthday} where id=#{id}")
    int updateUser(User user);

    @Select("select * from user")
    List<User> getAllUser();
}
