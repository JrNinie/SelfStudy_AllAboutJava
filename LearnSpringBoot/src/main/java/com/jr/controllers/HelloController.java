package com.jr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("hello")
public class HelloController {

    @ResponseBody
    @RequestMapping("/world")
    public String helloWorld(){
        return "hello spring";
    }
}
