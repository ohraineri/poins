package com.poins.api.context.annotation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.poins.api.http.annotations.Controller;
public class ClassPathScanning {
    static public final Reflections reflections = new Reflections("com.poins.api",
    Scanners.MethodsAnnotated,
    Scanners.TypesAnnotated,
    Scanners.MethodsParameter,
    Scanners.MethodsReturn
    );

    public static Set<Class<?>> getAllControllerClasses() {
        return ClassPathScanning.reflections.getTypesAnnotatedWith(Controller.class);
    }

    public static Map<String, Method[]> collectControllers() {
        Map<String, Method[]> controllers = new HashMap<String, Method[]>(); 
        Set<Class<?>> classControllers = ClassPathScanning.getAllControllerClasses();
        for(Class<?> controller : classControllers) {         
                Method[] controllerMethods = controller.getDeclaredMethods();
                controllers.put(controller.getName(), controllerMethods);
        }
        return controllers;
    }
}
