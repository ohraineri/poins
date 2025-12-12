package com.poins.api.http;

import java.util.Map;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
import com.poins.api.context.annotation.HttpHandler;
import com.poins.api.context.annotation.ClassPathScanning;

public class Server {
    public static HttpServer server;

    public void bind(InetSocketAddress port) {
        try {
            Map<String, Method[]> controllers = ClassPathScanning.collectControllers();
            HttpServer server = HttpServer.create(port, 0);
            HttpHandler handler = new HttpHandler(controllers);
            handler.registerRoutesFromMethods();
            server.start();
        } catch(IOException e) {
            throw new Error(e);
        }
    }    
}
