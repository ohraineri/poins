package com.poins.api.annotations;

import framework.http.Route;
import framework.http.Router;
import framework.http.enums.HttpMethod;

import java.lang.reflect.InvocationTargetException;

public class ClassHandler {

    static public void callMethod(HttpMethod requestMethod, String requestURI) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Route routeData = Router.getInstance().get(requestURI);

        Object clazz = routeData.handlerClass().getConstructor().newInstance();
        routeData.handler().invoke(clazz);
    }
}
