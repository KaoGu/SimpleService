package com.lyt.simpleservice.controller;

import com.lyt.simpleservice.mybatis.service.UserService;
import com.lyt.simpleservice.mybatis.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/v1/users")
    public List<UserInfo> queryAllUsers() {
        return userService.queryAllUsers();
    }

    @PostMapping("/v1/users")
    public void insertUsers(@RequestBody List<UserInfo> userInfoList) {
        userService.insertUsers(userInfoList);
    }

    @DeleteMapping("/v1/users/{id}")
    public int deleteUser(@PathVariable String id ) {
        return userService.deleteUser(id);
    }
}
