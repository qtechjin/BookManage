package com.xiaomi.example.dal.repository.impl;

import com.xiaomi.example.convert.OrderConvert;
import com.xiaomi.example.dal.dao.OrderDAO;
import com.xiaomi.example.dal.repository.OrderRepository;
import com.xiaomi.example.pojo.Order;

import javax.annotation.Resource;

/**
 * Created by mi on 2017/3/28.
 */
public class DefaultOrderRepository implements OrderRepository {
    @Resource
    private OrderDAO orderDAO;


    public Order loadByOrderId(int orderId) {
        Order order = OrderConvert.convert(orderDAO.selectByPrimaryKey(orderId));
        return order;
    }
}
