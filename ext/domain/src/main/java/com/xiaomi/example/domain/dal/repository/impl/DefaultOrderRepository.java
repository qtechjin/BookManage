package com.xiaomi.example.domain.dal.repository.impl;

import com.xiaomi.example.domain.convert.OrderConvert;
import com.xiaomi.example.domain.dal.dao.OrderDAO;
import com.xiaomi.example.domain.dal.repository.OrderRepository;
import com.xiaomi.example.domain.pojo.Order;

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
