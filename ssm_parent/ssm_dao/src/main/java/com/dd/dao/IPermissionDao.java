package com.dd.dao;

import com.dd.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    //通过用户id进行权限信息查询
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findPermissionsByRoleId(Integer roleId);

    //查询所有的权限
    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void savePermission(Permission permission);
}
