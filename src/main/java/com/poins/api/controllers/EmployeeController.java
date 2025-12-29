package com.poins.api.controllers;

import com.poins.api.entities.Customer;
import framework.http.annotations.Controller;
import framework.http.annotations.methods.Get;
import framework.http.annotations.methods.Put;
import framework.http.annotations.methods.Post;
import framework.http.annotations.methods.Delete;
import framework.http.annotations.parameters.RequestBody;

@Controller("/customers")
public class CustomerController {
    @Get("/test")
    public void index() {
        // Get Route
    }

    @Get("/")
    public void getAll() {
        // Get Route
    }

    @Post("/")
    public void store(@RequestBody Customer customer) {
        // Post Route
    }

    @Put("/")
    public void update() {
        System.out.println("UPDATE - Route");
        // Update Route
    }
    
    @Delete
    public void delete() {
        // Delete Route
    }
}
