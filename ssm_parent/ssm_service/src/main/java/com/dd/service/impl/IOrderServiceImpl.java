package com.dd.service.impl;

import com.dd.Orders;
import com.dd.dao.IOrdersDao;
import com.dd.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IOrderServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Orders> findAll() {
        return iOrdersDao.findAll();
    }

    /**
     * 通过id进行查询
     *
     * @param id
     * @return
     */
    @Override
    public Orders findOrdersById(int id) {
        return iOrdersDao.findOrdersById(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Orders> findAll(Integer page, Integer size) {
        //pageNum是页码值， 参数pagesize 代表的是每页显示条数
        PageHelper.startPage(page, size);
        return iOrdersDao.findAll();
    }

    /**
     * 删除订单，删除之前需要先删除外键
     * 外键在下面的两个方法中删除
     *
     * @param id
     */
    @Override
    public void deleteOrderById(Integer id) {
        iOrdersDao.deleteOrderById(id);
    }

    /**
     * 删除product_order中的外键
     * @param id
     */
    @Override
    public void deleteForeignKeyByOrderId(Integer id) {
        iOrdersDao.deleteForeignKeyByOrderId(id);
    }

    /**
     *  删除order_traveller中的外键
     * @param id
     */
    @Override
    public void deleteForeignKey2ByOrderId(Integer id) {
        iOrdersDao.deleteForeignKey2ByOrderId(id);
    }


}
