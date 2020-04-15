package com.itcast.controllers;

import com.itcast.exceptions.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class ExceptionController {

    @RequestMapping("handler")
    public String testHandler()throws SysException{

        //模拟错误，并抛出自定义异常
//        try {
//            int a = 10/0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new SysException("查询用户出现错误");
//        }

        return "success";
    }
}
