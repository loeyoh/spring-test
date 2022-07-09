package com.spring.sample.master.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.sample.master.common.aop.annotation.Decode;
import com.spring.sample.master.dto.MyUser;
import com.spring.sample.master.service.MyService;


@RestController
public class MyController {
    
    @Autowired
    private MyService service;

    @GetMapping("/test/{param}")
    @ResponseBody
    public ResponseEntity<?> testGet(@PathVariable("param") int param) {
        return new ResponseEntity<>(service.testGetMethod(param), HttpStatus.OK);
    }

    @PostMapping("/test")
    @ResponseBody
    @Decode
    public ResponseEntity<?> testPost(@RequestBody MyUser myUser) {
        return new ResponseEntity<>(service.testPostMethod(myUser), HttpStatus.OK);
    }
}
