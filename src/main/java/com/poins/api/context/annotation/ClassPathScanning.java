package com.poins.api.context.annotation;

import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.poins.api.http.annotations.Controller;
public class ClassPathScanning {
    static public Reflections reflections = new Reflections("com.poins.api", Scanners.MethodsAnnotated, Scanners.TypesAnnotated);

    public static Set<Class<?>> getAllControllerClasses() {
        Set<Class<?>> controllers = ClassPathScanning.reflections.getTypesAnnotatedWith(Controller.class);
        return controllers;
    }
}
