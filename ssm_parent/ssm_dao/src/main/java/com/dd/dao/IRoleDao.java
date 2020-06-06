package com.dd.dao;

import com.dd.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.dd.dao.IPermissionDao.findPermissionsByRoleId"))
    })
    List<Role> findByUserId(Integer userId);

    @Select("select * from role")
    List<Role> finAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void saveRole(Role role);
}
