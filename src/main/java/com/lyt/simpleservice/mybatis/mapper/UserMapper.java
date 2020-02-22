package com.lyt.simpleservice.mybatis.mapper;

import com.lyt.simpleservice.mybatis.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserInfo> queryAllUsers();

    void insertUsers(@Param("userInfoList") List<UserInfo> userInfoList);

    int deleteUser(@Param("id") String id);
}
