package com.dd.service;

import com.dd.Orders;
import com.dd.Product;

import java.util.List;

public interface IProductService {

    //查询所有商品
    List<Product> findAll();

    //分页查询
    List<Product> findAll(Integer page, Integer size);

    //查询byid
    Product findProductById(Integer id);

    //保存商品
    void saveProduct(Product product);

    //修改商品
    void modifyProduct(Product product);

    //删除商品
    void deleteProductById(Integer id);

    //通过产品id查找订单
    List<Orders> findOrdersById(Integer id, Integer page, Integer size);

}
