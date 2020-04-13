package com.itcast.controllers;

import com.itcast.domain.Account;
import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/test")
public class HelloController {

    //value和path完全一样，而且可以省略
    @RequestMapping(value="/hello")
    public String sayHello(){
        System.out.println("in HelloController");
        return "success";
    }


    //method接收的是数组，可以传多个RequestMethod
    //因为变成了POST，那么<a href="test/requestMapping"> request mapping</a>就报错了
    @RequestMapping(path="/requestMapping", method = {RequestMethod.POST})
    public String testRequestMapping(){
        System.out.println("in testRequestMapping");
        return "success";
    }

    //params设置参数
    //如果发来的请求没有对应的username参数href="test/requestMapping"，则报错
    //正确写法href="test/requestMapping?username=Lucie"
    @RequestMapping(path="/requestMapping", params = {"username"})
    public String testRequestMappingParams(){
        System.out.println("in testRequestMapping");
        return "success";
    }

    //必须要写成href="test/requestMapping?username=Linda"
    @RequestMapping(path="/requestMapping2", params = {"username=Linda"})
    public String testRequestMappingParams2(){
        System.out.println("in testRequestMapping");
        return "success";
    }

    @RequestMapping(path="/requestMapping3", params = {"username!=Linda"})
    public String testRequestMappingParams3(){
        System.out.println("in testRequestMapping");
        return "success";
    }


    //自动接收jsp传递的信息：要求保持参数的名字一致（username， password）
    //href="test/requestMapping4?username=Linda&password=123"
    @RequestMapping(path="/requestMapping4")
    public String testRequestMappingParams4(String username, String password){
        System.out.println("in testRequestMapping"+ username + password);
        return "success";
    }


    //可以直接接收由java bean封装好的参数哦
    @RequestMapping(path="/requestMapping5")
    public String testRequestMappingParams5(Account account){
        System.out.println("in testRequestMapping" + account);
        return "success";
    }

    @RequestMapping("userDate")
    public String testUserDate(User user){
        System.out.println(user);
        return "success";
    }
}
