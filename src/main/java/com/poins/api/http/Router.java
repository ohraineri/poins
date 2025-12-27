package com.poins.api.http;


import java.util.Map;
import java.util.HashMap;

public class Router {
	static private Map<String, Route>registeredRoutes = new HashMap<String, Route>();
		
	static public Map<String, Route> getInstance() {
		return Router.registeredRoutes;
	}
	
	static public Map<String, Route> registerRoutes(Map<String, Route> routes) {
		Router.registeredRoutes = routes;
		return Router.registeredRoutes;
	}
}
