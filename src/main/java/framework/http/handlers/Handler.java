package com.poins.api.annotations;

import java.io.IOException;
import java.io.OutputStream;

import framework.http.enums.HttpMethod;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import framework.http.validation.HttpHandlerRules;
import framework.http.validation.ValidationResult;

public class Handler implements HttpHandler {
    
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        String response = "It's working";
        System.out.println(exchange.getProtocol() + ", " + exchange.getRequestMethod());
        ValidationResult validation = HttpHandlerRules.validate(exchange);
        // TODO: Refactor
        if(validation.statusCode > 299)
            response = validation.responseMessage;

        try {
            ClassHandler.callMethod(HttpMethod.valueOf(exchange.getRequestMethod()), exchange.getRequestURI().toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /////////
        exchange.sendResponseHeaders(validation.statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}