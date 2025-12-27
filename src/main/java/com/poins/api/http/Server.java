package com.poins.api.http;

import java.util.Map;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.poins.api.annotations.HttpHandler;
import com.poins.api.scanner.ClassPathScanning;

public class Server {
    public static HttpServer server;

    public void bind(InetSocketAddress port) {
        try {
        	Router.registerRoutes(ClassPathScanning.collectRoutes());
            HttpServer serverInstance = HttpServer.create(port, 0);
            Server.server = serverInstance;
            HttpHandler handler = new HttpHandler();
            handler.registerRoutesFromMethods();
            serverInstance.start();
        } catch(Exception e) {
            throw new Error(e);
        }
    }
}
