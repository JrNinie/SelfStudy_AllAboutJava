package com.itcast.controllers;

import com.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("response")
@SessionAttributes(value={"msg"})
public class ResponseController {

    @RequestMapping("string")
    public String responseString(Model model){
        //模拟从数据库取出User信息
        User user = new User();
        user.setUname("Lisa");
        user.setAge(30);
        //通过model把user信息放入request作用域中
        model.addAttribute("myUser", user);
        return "success";
    }


    //当是void的时候，默认执行完毕去voidtest.jsp（RequestMapping的名字.jsp）
    @RequestMapping("voidtest")
    public void responseVoidDefault(){
        System.out.println("in responseVoidDefault");
    }


    @RequestMapping("voidtest2")
    public void responseVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in responseVoid");
        //如果请求转发，利用HttpServletRequest
        //手动转发，不会去调用视图解析器，因此要自己手动写路径（除了项目名的路径，也就是webapp后面的路径）
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        //如果是重定向,路径要加上项目名(用request.getContextPath()来获取)
//        System.out.println("contextPath"+request.getContextPath());
//        response.sendRedirect(request.getContextPath()+"/index.jsp");

        //直接进行响应(先做解决中文乱码问题)
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("直接进行响应");

    }


    @RequestMapping("modelandview")
    public ModelAndView responseModelAndView(){
        ModelAndView mv = new ModelAndView();
        //往request域中添加对象
        mv.addObject("msg","message by ModelAndView");
        //前往message.jsp页面
        mv.setViewName("message");
        return mv;
    }


    @RequestMapping("forward")
    public String forward(){
        //转发：一次请求
       return "forward:/WEB-INF/pages/success.jsp";
    }


    @RequestMapping("redirect")
    public String redirect(HttpServletRequest request){
        //重定向：两次请求
        //但是spring比原生的HttpServletRequest高级在不需要通过request.getContextPath()添加项目名
        return "redirect:/index.jsp";
    }

}
