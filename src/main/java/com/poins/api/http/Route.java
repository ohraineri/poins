package com.poins.api.http;

import java.lang.reflect.Method;

public record Route(String method, Method handler, Class<?> handlerClass, String path) {}
