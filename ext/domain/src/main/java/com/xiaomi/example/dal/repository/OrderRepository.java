package com.xiaomi.example.dal.repository;

import com.xiaomi.example.pojo.Order;

/**
 * Created by mi on 2017/3/28.
 */
public interface OrderRepository {

    public Order loadByOrderId(int orderId);
}
