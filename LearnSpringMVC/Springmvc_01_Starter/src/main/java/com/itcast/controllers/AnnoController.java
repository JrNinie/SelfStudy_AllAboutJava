package com.itcast.controllers;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
//@SessionAttributes("msg")
@SessionAttributes(value = {"msg"})
public class AnnoController {

    @RequestMapping("testParams")
    //那么要求传入的参数名必须是uage（哪怕是age都不行），required默认是true，那么这里是false就可以不传
    public String testParams(@RequestParam(name="uage", required=false) int age){
        System.out.println(age);
        return "success";
    }


    @RequestMapping("body")
    //如果不加@RequestBody,意味着要获取名字为body的属性
    public String testBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }


    @RequestMapping("path/{userid}")
    //PathVariable里面的value要和占位符{userid}的名字一致
    public String testPath(@PathVariable("userid") String id){
        System.out.println(id);
        return "success";
    }


    @RequestMapping("header")
    public String testHeader(@RequestHeader(value = "Accept") String header){
        System.out.println(header);
        return "success";
    }

//    @RequestMapping("modelAttribute")
//    public String testUser1(User user){
//        System.out.println(user);
//        return "success";
//    }
//
//    @ModelAttribute
//    public User testModelAttribute1(String uname){
//        System.out.println("model attribute 方法");
//        //模拟去数据库中查找
//        User user = new User();
//        user.setUname(uname);
//        user.setAge(30);
//        user.setBirthday(new Date());
//        return user;
//    }


    @RequestMapping("modelAttribute")
    public String testUser2(@ModelAttribute(value = "abc") User user){
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void testModelAttribute2(String uname, Map<String, User> userMap){
        System.out.println("model attribute 方法");
        //模拟去数据库中查找
        User user = new User();
        user.setUname(uname);
        user.setAge(30);
        user.setBirthday(new Date());

        userMap.put("abc", user);

    }


    //利用HttpServletRequest来setAttribute耦合度太高，不推荐，要用Model来传递
//    @RequestMapping("setSessionAttributes")
//    public String setSessionAttributes(HttpServletRequest request){
//        request.setAttribute("msg", "通过HttpRequest传递的信息");
//        return "message";
//    }


    //这里的Model就相当于HttpServletRequest
    @RequestMapping("setSessionAttributes")
    public String setSessionAttributes(Model model){
        model.addAttribute("msg", "通过Model传递的信息");
        return "message";
    }


    @RequestMapping("getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
       String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "message";
    }


    @RequestMapping("deleteSessionAttributes")
    public String deleteSessionAttributes(SessionStatus sessionStatus){
        //设置setComplete()也就是说完成了，可以结束删除了
        sessionStatus.setComplete();
        return "message";
    }
}
