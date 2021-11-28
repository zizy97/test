package com.quikapp.test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class QuikAppHome {
    @GetMapping("home")
    public ResponseEntity<?> getHome(){
        return new ResponseEntity<>("<h1>Home<h1>", HttpStatus.OK);
    }

}
