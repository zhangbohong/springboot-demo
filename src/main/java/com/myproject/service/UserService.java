package com.myproject.service;

import com.myproject.common.dataSourceUntil.TargetDataSource;
import com.myproject.dao.IUserMapper;
import com.myproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserService {
    @Resource
    IUserMapper iUserMapper;



    public List<User> getAllUser() {
        // TODO 自动生成的方法存根
        return iUserMapper.getAllUser();
    }

    @TargetDataSource(value = "readonly")
    public User getUserByID(int id) {
        // TODO 自动生成的方法存根
        return iUserMapper.getUserByID(id);
    }

    public int deleteUserById(int id) {
        // TODO 自动生成的方法存根
        return iUserMapper.deleteUserById(id);
    }

    public int updateUser(User user) {
        // TODO 自动生成的方法存根
        return iUserMapper.updateUser(user);
    }
}
