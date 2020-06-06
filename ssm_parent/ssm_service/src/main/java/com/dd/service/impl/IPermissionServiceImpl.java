package com.dd.service.impl;

import com.dd.Permission;
import com.dd.dao.IPermissionDao;
import com.dd.service.IPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IPermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;


    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    //分页查询
    @Override
    public List<Permission> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return permissionDao.findAll();
    }
}
