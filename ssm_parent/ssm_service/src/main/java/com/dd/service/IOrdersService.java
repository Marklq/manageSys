package com.dd.service;

import com.dd.Orders;

import java.util.List;

public interface IOrdersService {

    //查询所有
    List<Orders> findAll();

    //通过id进行查询
    Orders findOrdersById(int id);

    //分页查询
    List<Orders> findAll(Integer page, Integer size);

    //删除订单信息,删除之前需要先删除外键
    //外键在下面的两个方法中删除
    void deleteOrderById(Integer id);

    //删除product_order中的外键
    void deleteForeignKeyByOrderId(Integer id);

    //删除order_traveller中的外键
    void deleteForeignKey2ByOrderId(Integer id);
}
