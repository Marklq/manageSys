package com.dd.dao;

import com.dd.Member;
import com.dd.Orders;
import com.dd.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {

    //查询所有
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class, one = @One(select = "com.dd.dao.IProductDao.findProductById")),
    })
    List<Orders> findAll();


    //通过id进行订单查询
    @Select("select * from orders where id  = #{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productId",
                    javaType = Product.class, one = @One(select = "com.dd.dao.IProductDao.findProductById")),
            @Result(property = "member", column = "memberId",
                    javaType = Member.class, one = @One(select = "com.dd.dao.IMemberDao.findMemberById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class,
                    many = @Many(select = "com.dd.dao.ITravellerDao.findByOrdersId")),
    })
    Orders findOrdersById(int id);

    //通过订单id删除订单信息，删除之前需要先删除外键
    @Delete("delete from orders where id = #{id}")
    void deleteOrderById(Integer id);

    //删除product_order中的外键
    @Delete("delete from order_traveller where orderId = #{id}")
    void deleteForeignKeyByOrderId(Integer id);

    //删除order_traveller中的外键
    @Delete("delete from product_order where orderId = #{id}")
    void deleteForeignKey2ByOrderId(Integer id);
}
