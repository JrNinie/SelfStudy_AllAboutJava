package com.jr.learning.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @GetMapping("/th")
    public String thymeleaf(Model model) {
        model.addAttribute("msg", "message for thymeleaf");
        model.addAttribute("users", Arrays.asList("a", "b", "c"));
        return "useThymeleaf";
    }
}
