package com.dd.service.impl;

import com.dd.Role;
import com.dd.dao.IRoleDao;
import com.dd.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.finAll();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Role> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return roleDao.finAll();
    }


}
