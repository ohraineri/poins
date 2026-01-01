package com.poins.api.controllers;

import com.poins.api.entities.Employee;
import framework.http.annotations.Controller;
import framework.http.annotations.methods.Get;
import framework.http.annotations.methods.Put;
import framework.http.annotations.methods.Post;
import framework.http.annotations.methods.Delete;
import framework.http.annotations.parameters.RequestBody;

@Controller("/employee")
public class EmployeeController {
    @Get("/test")
    public void index() {
        // Get Route
    }

    @Get("/")
    public void getAll() {
        // Get Route
    }

    @Post("/")
    public void store(@RequestBody Employee employee) {
        // Post Route
    }

    @Put("/")
    public void update(@RequestBody Employee employee) {
        // Update Route
    }
    
    @Delete
    public void delete() {
        // Delete Route
    }
}
