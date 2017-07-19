package com.xiaomi.example.domain.convert;

import com.xiaomi.example.domain.dal.dataobject.OrderDO;
import com.xiaomi.example.domain.pojo.Order;

/**
 * Created by mi on 2017/3/23.
 */
public class OrderConvert {
    public static Order convert(OrderDO orderDO){
        if (orderDO == null) {
            return null;
        }
        Order order = new Order();
        order.setOrderId(orderDO.getOrderId());
        order.setOrderNo(orderDO.getOrderNo());
        order.setUserId(orderDO.getUserId());
        order.setBookIsbn(orderDO.getBookIsbn());
        order.setCount(orderDO.getCount());
        order.setRemark(orderDO.getRemark());
        return order;
    }

    public static OrderDO convert(Order order){
        if (order == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        orderDO.setOrderId(order.getOrderId());
        orderDO.setOrderNo(order.getOrderNo());
        orderDO.setUserId(order.getUserId());
        orderDO.setBookIsbn(order.getBookIsbn());
        orderDO.setCount(order.getCount());
        orderDO.setRemark(order.getRemark());
        return orderDO;
    }
}
