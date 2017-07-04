package com.xiaomi.example.utils;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mi on 2017/3/1.
 */
public class HttpServletProxy extends HttpServlet {
    private static final long serialVersionUID = -7208519469035631940L;

    private Logger logger = Logger.getLogger(HttpServletProxy.class);
    private String targetServlet;
    private HttpServlet proxy;
    public void init() throws ServletException {
        this.targetServlet = getInitParameter("targetServlet");
        getServletBean();
        proxy.init(getServletConfig());
        logger.info(targetServlet + " was initailized");

    }
    private void getServletBean(){
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        this.proxy = (HttpServlet) ac.getBean(targetServlet);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proxy.service(request, response);
    }
}
