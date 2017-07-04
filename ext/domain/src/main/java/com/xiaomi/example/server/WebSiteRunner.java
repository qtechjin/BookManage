package com.xiaomi.example.server;


import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;

/**
 * Created by mi on 2017/3/21.
 */
public class WebSiteRunner {
    private static Server server = new Server();

    public static void main(String[] args) throws Exception{
        QueuedThreadPool boundedThreadPool = new QueuedThreadPool();
        boundedThreadPool.setMaxThreads(5);
        server.setThreadPool(boundedThreadPool);

        Connector connector = new SelectChannelConnector();
        connector.setPort(8091);
        server.addConnector(connector);

        WebAppContext context = new WebAppContext("src/main/webapp", "/");
        server.setHandler(context);

        server.setStopAtShutdown(true);
        server.setSendServerVersion(true);

        server.start();
        server.join();
    }
}
