package com.dd.dao;

import com.dd.Orders;
import com.dd.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductDao {

    //查询
    @Select("select * from product")
    List<Product> findAll();

    //查询byID
    @Select("select * from product where id = #{id}")
    Product findProductById(int id);

    //保存
    @Insert("insert into product(productNum,productName,cityName,time,productPrice,productDesc,productStatus)" +
            " values(#{productNum},#{productName},#{cityName},#{time},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);

    //修改
    @Insert("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},time=#{time}," +
            "productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus}" +
            " where id = #{id}")
    void modifyProduct(Product product);

    /**
     * 根据id删除产品
     *
     * @param id
     */
    @Select("delete from product where id = #{id}")
    void deleteProductById(Integer id);

    /**
     * 根据产品id查询订单信息
     *
     * @param id
     * @return
     */
    @Select("select * from orders where id in (select orderId from product_order where ProductId = #{id})")
    List<Orders> findOrdersById(Integer id);

}
