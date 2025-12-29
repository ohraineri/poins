package framework.http;

import java.util.Set;

import framework.http.enums.HttpMethod;

import java.lang.reflect.Method;

public record Route(Set<HttpMethod> allowedMethods, Method handler, Class<?> handlerClass, String path) {
	public void addAllowedMethod(HttpMethod method) {
		this.allowedMethods.add(method);
	}
	
	public boolean allowsMethod(HttpMethod method) {
		return allowedMethods.contains(method);
	}
}
