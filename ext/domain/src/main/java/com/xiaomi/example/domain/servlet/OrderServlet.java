package com.xiaomi.example.domain.servlet;

import com.alibaba.fastjson.JSON;
import com.xiaomi.example.domain.dal.dao.OrderDAO;
import com.xiaomi.example.domain.dal.dataobject.OrderDO;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mi on 2017/3/1.
 */
public class OrderServlet extends HttpServlet {
//    @Resource
    private OrderDAO orderDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        orderDAO = (OrderDAO) ac.getBean("orderDAO");
        OrderDO order = orderDAO.selectByPrimaryKey(2);

        pw.write("order");
        pw.write(JSON.toJSONString(order));
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
