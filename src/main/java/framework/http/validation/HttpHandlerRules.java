package framework.http.validation;

import framework.http.Router;
import framework.http.enums.HttpMethod;
import com.sun.net.httpserver.HttpExchange;

public class HttpHandlerRules {
    private HttpHandlerRules() {}

    public static ValidationResult validate(HttpExchange exchange) {
        if(!isSameRoute(exchange))
            return ValidationResult.error(404, "Not Found");
        if(!isMethodAllowed(exchange))
            return ValidationResult.error(405, "Method Not Allowed");       	
        return ValidationResult.ok();
    }

    public static boolean isSameRoute(HttpExchange exchange) {
        return exchange.getRequestURI().toString().equals(exchange.getHttpContext().getPath());
    }

    public static boolean isMethodAllowed(HttpExchange exchange) {
    	return Router.getInstance().get(exchange.getRequestURI().toString()).allowsMethod(HttpMethod.valueOf(exchange.getRequestMethod()));
    }
}
