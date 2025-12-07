package com.poins.api;

import com.poins.api.http.Server;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) {
        Server server = new Server();
        server.server(new InetSocketAddress(8080));
    }
}
