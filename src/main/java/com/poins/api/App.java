package com.poins.api;

import framework.http.Server;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) {
        Server server = new Server();
        server.bind(new InetSocketAddress(8080));
    }
}
