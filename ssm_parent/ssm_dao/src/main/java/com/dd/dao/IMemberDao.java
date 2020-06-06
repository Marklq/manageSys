package com.dd.dao;

import com.dd.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {

    //通过id进行查询
    @Select("select * from member where id = #{id}")
    Member findMemberById(Integer id);


}
