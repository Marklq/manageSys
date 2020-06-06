package com.dd.service;

import com.dd.Role;

import java.util.List;

public interface IRoleService {


    List<Role> findAll();

    void saveRole(Role role);

    //分页查询
    List<Role> findAll(Integer page, Integer size);
}
