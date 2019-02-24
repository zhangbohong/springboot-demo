package com.myproject.service;

import com.myproject.common.dataSourceUntil.TargetDataSource;
import com.myproject.dao.mybatis.IUserMapper;
import com.myproject.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "userService")
public class UserService {
    @Resource
    IUserMapper iUserMapper;


    @TargetDataSource(TargetDataSource.master)
    public List<User> getAllUser() {
        // TODO 自动生成的方法存根
        return iUserMapper.getAllUser();
    }

    @TargetDataSource(TargetDataSource.readonly)
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
