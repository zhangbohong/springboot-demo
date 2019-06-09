package com.myproject.service;

import com.myproject.common.utils.datasource.TargetDataSource;
import com.myproject.dao.mybatis.mapper.IUserMapper;
import com.myproject.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserService {
    @Autowired
    IUserMapper iUserMapper;


    @TargetDataSource(TargetDataSource.master)
    public List<User> getAllUser() {
        return iUserMapper.getAllUser();
    }

    @TargetDataSource(TargetDataSource.readonly)
    public User getUserByID(int id) {
        return iUserMapper.getUserByID(id);
    }

    public int deleteUserById(int id) {
        return iUserMapper.deleteUserById(id);
    }

    public int updateUser(User user) {
        return iUserMapper.updateUser(user);
    }
}
