package com.poins.api.controllers;

import com.poins.api.http.annotations.Controller;
import com.poins.api.http.annotations.Delete;
import com.poins.api.http.annotations.Get;
import com.poins.api.http.annotations.Post;
import com.poins.api.http.annotations.Put;

@Controller("/customer")
public class CustomerController {
    @Get("/test")
    public void index() {

    }

    @Get("/")
    public void getAll() {

    }

    // @Post("/")
    // public void store() {

    // }

    // @Put("/")
    // public void update() {

    // }
    
    // @Delete
    // public void delete() {

    // }
}
