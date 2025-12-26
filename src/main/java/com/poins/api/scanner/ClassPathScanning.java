package com.poins.api.scanner;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import com.poins.api.http.Route;
import com.poins.api.http.annotations.Controller;
import com.poins.api.http.annotations.HttpRoute;
public class ClassPathScanning {
    static public final Reflections reflections = new Reflections("com.poins.api",
    Scanners.MethodsReturn,
    Scanners.TypesAnnotated,
    Scanners.MethodsAnnotated,
    Scanners.MethodsParameter
    );

    public static Set<Class<?>> getAllControllerClasses() {
        return ClassPathScanning.reflections.getTypesAnnotatedWith(Controller.class);
    }

    public static Map<Class<?>, Method[]> collectControllers() {
        Map<Class<?>, Method[]> controllers = new HashMap<Class<?>, Method[]>(); 
        Set<Class<?>> classControllers = ClassPathScanning.getAllControllerClasses();
        for(Class<?> controller : classControllers) {         
            Method[] controllerMethods = controller.getDeclaredMethods();
            controllers.put(controller, controllerMethods);
        }
        return controllers;
    }

    public static Map<String, Route> registerRoutes() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Set<Class<?>> controllers = ClassPathScanning.getAllControllerClasses();
        Map<String, Route> routerList = new HashMap<String, Route>();

        for(Class<?> controller : controllers) {
            for(Method method : controller.getDeclaredMethods()) {
                for(Annotation annotation : method.getAnnotations()) {
                    Class<? extends Annotation> annotationType = annotation.annotationType();
                    if (!annotationType.isAnnotationPresent(HttpRoute.class))
                        continue;
                    Method valueMethod = annotation.annotationType().getMethod("value");
                    Object value = valueMethod.invoke(annotation);

                    HttpRoute httpRoute = annotationType.getAnnotation(HttpRoute.class);
                    routerList.put(value.toString(), new Route(httpRoute.method(), method, controller, value.toString()));
                }
            }
        }
        return routerList;
    }
}
