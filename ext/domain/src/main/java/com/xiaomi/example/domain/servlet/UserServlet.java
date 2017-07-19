package com.xiaomi.example.domain.servlet;

import com.xiaomi.example.domain.dal.dao.UserDAO;
import com.xiaomi.example.domain.dal.dataobject.UserDO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mi on 2017/2/28.
 */
//@WebServlet(name = "UserServlet", urlPatterns = "/servlet/user")
public class UserServlet extends javax.servlet.http.HttpServlet {
    @Resource
    private UserDAO userDAO;
    public void setUserDAO(UserDAO userDAO){
        this.userDAO = userDAO;
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write("hello world!");
        pw.write("get bean");

        UserDO user = userDAO.selectByPrimaryKey(40);
        pw.write("user");
        pw.write(user.toString());
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
