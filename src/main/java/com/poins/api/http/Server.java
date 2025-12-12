package com.poins.api.http;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;

import com.poins.api.context.annotation.ClassPathScanning;
import com.poins.api.context.annotation.HttpHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Server {
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
