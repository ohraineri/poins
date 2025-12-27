package com.poins.api.http.annotations;

import java.lang.annotation.Target;

import com.poins.api.http.enums.HttpMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@HttpRoute(method = HttpMethod.POST)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Post {
    public String value() default "/";
    
}