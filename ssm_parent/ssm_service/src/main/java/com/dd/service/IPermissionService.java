package com.dd.service;

import com.dd.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> findAll();

    void savePermission(Permission permission);

    //分页查询
    List<Permission> findAll(Integer page, Integer size);

}
