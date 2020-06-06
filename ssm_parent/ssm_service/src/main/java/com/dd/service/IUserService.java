package com.dd.service;

import com.dd.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {



    //查询所有用户
    List<UserInfo> findAll();

    //新建用户
    void saveUser(UserInfo userInfo);

    //通过id进行查询
    UserInfo findUserById(Integer id);

    //分页查询
    List<UserInfo> findAll(Integer page, Integer size);
}
