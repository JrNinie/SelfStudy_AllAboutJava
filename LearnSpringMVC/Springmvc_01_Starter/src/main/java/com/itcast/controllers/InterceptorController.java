package com.itcast.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("interceptor")
public class InterceptorController {

    private ModelAndView mv = new ModelAndView();

    @RequestMapping("pre")
    public ModelAndView pre(){
        System.out.println("in controller");
        mv.setViewName("success");
        return  mv;
    }
}
