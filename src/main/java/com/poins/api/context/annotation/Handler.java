package com.poins.api.context.annotation;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import com.poins.api.context.annotation.validations.HttpHandlerRules;
import com.poins.api.context.annotation.validations.ValidationResult;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Handler implements HttpHandler {
    
    @Override
    public void handle(HttpExchange exchange) throws IOException 
    {
        String response = "It's working";
        System.out.print(exchange.getProtocol() + "," + exchange.getRequestMethod() + "," + exchange.getHttpContext() + "\n");
        ValidationResult validation = HttpHandlerRules.validate(exchange);
        if(validation.statusCode > 299)
            response = validation.responseMessage;
        
        System.out.print(validation.statusCode + "\n");
        exchange.sendResponseHeaders(validation.statusCode, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}