package com.poins.api.validation;

import com.sun.net.httpserver.HttpExchange;

public class HttpHandlerRules {
    private HttpHandlerRules() {}

    public static ValidationResult validate(HttpExchange exchange) {
        if(!isSameRoute(exchange))
            return ValidationResult.error(404, "Not Found");
        return ValidationResult.ok();
    }

    public static boolean isSameRoute(HttpExchange exchange) {
        return exchange.getRequestURI().toString().equals(exchange.getHttpContext().getPath());
    }
}
