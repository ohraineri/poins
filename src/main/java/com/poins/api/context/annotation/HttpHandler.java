package com.poins.api.context.annotation;

import java.lang.reflect.Method;
import java.util.Map;

import com.poins.api.http.Server;
import com.poins.api.http.annotations.Get;
public class HttpHandler {
    private Map<String, Method[]> controllers;

    public HttpHandler(Map<String, Method[]> controller) {
        this.controllers = controller;
    } 

    public void registerRoutesFromMethods() {
        for(Map.Entry<String, Method[]> controller : this.controllers.entrySet()) {
            for(int i = 0; i < controller.getValue().length; i++) {
            Server.server.createContext(controller.getValue()[i].getAnnotation(Get.class).value(), new Handler());
            }
        }
    }
}
