package com.dd.service.impl;

import com.dd.Role;
import com.dd.UserInfo;
import com.dd.dao.IUserDao;
import com.dd.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = userDao.findByUsername(username);

        //查询用户信息  以及和用户id所对应的角色信息
        //进行用户是否开启状态验证   同时可以进行用户权限的验证
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true,
                true, true, getAuthority(userInfo.getRoles()));

        return user;
    }

    //获取用户权限   返回一个list集合  集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
//        打印权限到控制台
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println("____________________________");
        }
        return list;
    }


    //查询所有
    public List<UserInfo> findAll() {

        return userDao.findAll();
    }

    //新建用户信息
    @Override
    public void saveUser(UserInfo userInfo) {
        userDao.saveUser(userInfo);
    }

    //通过id查询用户
    @Override
    public UserInfo findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        //pageNum是页码值， 参数pagesize 代表的是每页显示条数
        PageHelper.startPage(page,size);
        return userDao.findAll();
    }


}
