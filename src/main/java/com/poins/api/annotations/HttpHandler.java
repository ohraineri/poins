package com.poins.api.annotations;

import java.util.Map;


import com.poins.api.http.Route;
import com.poins.api.http.Router;
import com.poins.api.http.Server;

public class HttpHandler {

    public HttpHandler() {
    } 

    public void registerRoutesFromMethods() {
        for(Map.Entry<String, Route> route : Router.getInstance().entrySet()) { 
        	Server.server.createContext(route.getKey(), new Handler());
        }
    }
}
