package com.xiaomi.example.domain.dal.repository;

import com.xiaomi.example.domain.pojo.Order;

/**
 * Created by mi on 2017/3/28.
 */
public interface OrderRepository {

    public Order loadByOrderId(int orderId);
}
