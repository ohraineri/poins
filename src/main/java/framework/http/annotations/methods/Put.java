package com.poins.api.http.annotations.methods;

import java.lang.annotation.Target;

import com.poins.api.http.annotations.HttpRoute;
import com.poins.api.http.enums.HttpMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@HttpRoute(method = HttpMethod.PUT)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Put {
    public String value() default "/";
}