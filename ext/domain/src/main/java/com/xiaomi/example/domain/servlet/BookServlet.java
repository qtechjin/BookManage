package com.xiaomi.example.domain.servlet;

import com.xiaomi.example.domain.dal.dao.BookDAO;
import com.xiaomi.example.domain.dal.dataobject.BookDO;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mi on 2017/2/28.
 */
//@WebServlet(name = "BookServlet")
public class BookServlet extends javax.servlet.http.HttpServlet {
    @Resource
    private BookDAO bookDAO;
    public void setBookDAO( BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();

        BookDO book = bookDAO.selectByPrimaryKey("978-7-115-41730-5");
        pw.write(book.toString());

        pw.flush();
        pw.close();
    }
}
