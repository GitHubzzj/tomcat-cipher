package com.byedbl.tomcat.cipher.simple.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    @ResponseBody
    @RequestMapping("test")
    public String hi(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request);

        return "hello world";
    }

}
