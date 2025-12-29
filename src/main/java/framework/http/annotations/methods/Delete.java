package com.poins.api.http.annotations.methods;

import java.lang.annotation.Target;

import com.poins.api.http.annotations.HttpRoute;
import com.poins.api.http.enums.HttpMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@HttpRoute(method = HttpMethod.DELETE)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Delete {
    public String value() default "/";
}
