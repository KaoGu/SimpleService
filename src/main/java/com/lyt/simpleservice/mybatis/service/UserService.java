package com.lyt.simpleservice.mybatis.service;

import com.lyt.simpleservice.mybatis.mapper.UserMapper;
import com.lyt.simpleservice.mybatis.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> queryAllUsers(){
        return userMapper.queryAllUsers();
    }

    public void insertUsers(List<UserInfo> userInfoList) {
        userMapper.insertUsers(userInfoList);
    }

    public int deleteUser(String id) {
        return userMapper.deleteUser(id);
    }

}
