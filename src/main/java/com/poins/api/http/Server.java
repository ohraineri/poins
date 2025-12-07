package com.poins.api.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class Server {
    static HttpServer server;
    public void server(InetSocketAddress port){
        try {
            HttpServer server = HttpServer.create(port, 0);
        } catch(IOException e) {
            throw new Error(e);
        }
    }
}
