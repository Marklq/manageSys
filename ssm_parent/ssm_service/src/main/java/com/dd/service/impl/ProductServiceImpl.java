package com.dd.service.impl;

import com.dd.Orders;
import com.dd.dao.IProductDao;
import com.dd.service.IProductService;
import com.dd.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    //查询
    @Override
    public List<Product> findAll() {

        return iProductDao.findAll();
    }

    @Override
    public List<Product> findAll(Integer page, Integer size) {
        //pageNum是页码值， 参数pagesize 代表的是每页显示条数
        PageHelper.startPage(page, size);
        return iProductDao.findAll();
    }

    //保存
    @Override
    public void saveProduct(Product product) {
        iProductDao.saveProduct(product);
    }

    //修改
    @Override
    public void modifyProduct(Product product) {
        iProductDao.modifyProduct(product);
    }

    //删除
    @Override
    public void deleteProductById(Integer id) {
        iProductDao.deleteProductById(id);
    }

    //通过产品id获取订单信息
    @Override
    public List<Orders> findOrdersById(Integer id, Integer page, Integer size) {
        PageHelper.startPage(page, size);
        List<Orders> list = iProductDao.findOrdersById(id);
        return list;
    }

    //查询byid
    @Override
    public Product findProductById(Integer id) {
        return iProductDao.findProductById(id);
    }
}
