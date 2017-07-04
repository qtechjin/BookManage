package com.xiaomi.example.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.example.dal.repository.OrderRepository;
import com.xiaomi.example.pojo.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by mi on 2017/3/28.
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    private Logger logger = Logger.getLogger("CONTROLLER-LOGGER");

    @Resource
    private OrderRepository orderRepository;

    @RequestMapping(value = "/{orderId}", method = GET)
    public String findOrder(@PathVariable("orderId") int orderId, Model model) {

        Order order = orderRepository.loadByOrderId(orderId);
        model.addAttribute("order", order);
        System.out.println("查询订单号:" + JSON.toJSONString(order));
        return "order";
    }

}
