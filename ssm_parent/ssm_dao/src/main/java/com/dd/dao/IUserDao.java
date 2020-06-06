package com.dd.dao;

import com.dd.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {

    @Select("select * from users where  username = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.dd.dao.IRoleDao.findByUserId")),
    })
    UserInfo findByUsername(String username);

    //查询所有
    @Select("select * from users")
    List<UserInfo> findAll();

    //新建用户
    @Select("insert into users (email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo);

    //通过id查询用户
    @Select("select * from users where id  = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.dd.dao.IRoleDao.findByUserId")),
    })
    UserInfo findUserById(Integer id);
}
