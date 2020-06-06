package com.dd.dao;

import com.dd.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    //通过ordersId建立多表查询
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    List<Traveller> findByOrdersId(Integer ordersId) throws Exception;

}
