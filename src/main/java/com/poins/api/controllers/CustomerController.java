package com.poins.api.controllers;

import com.poins.api.http.annotations.Get;
import com.poins.api.http.annotations.Put;
import com.poins.api.http.annotations.Post;
import com.poins.api.http.annotations.Delete;
import com.poins.api.http.annotations.Controller;

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

    @Post("/update")
    public void store() {
        // Post Route
    }

    @Put("/")
    public void update() {
        // Update Route
    }
    
    @Delete
    public void delete() {
        // Delete Route
    }
}
