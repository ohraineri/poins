package framework.http.handlers;

import java.util.Map;


import framework.http.Route;
import framework.http.Router;
import framework.http.Server;

public class HttpHandler {

    public HttpHandler() {
    } 

    public void registerRoutesFromMethods() {
        for(Map.Entry<String, Route> route : Router.getInstance().entrySet()) { 
        	Server.server.createContext(route.getKey(), new Handler());
        }
    }
}
