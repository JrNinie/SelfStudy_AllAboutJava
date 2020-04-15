package com.itcast.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//异常处理器，一旦controller抛出异常，dispatcherServlet就会找到这个异常处理器，也就会执行里面的方法resolveException
//因此在这里要写处理异常的逻辑
public class SysExceptionResolver implements HandlerExceptionResolver {

    @Override
    //Exception ex指接收到的异常
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        SysException e = null;
        //判断接收的异常ex是否是SysException类型的
        if(ex instanceof SysException){
            //强转成SysException类型
            e = (SysException)ex;
        }else{
            e = new SysException("系统正在维护");
        }

        ModelAndView mv = new ModelAndView();
//        e.getMessage()拿到controller抛出的错误信息
        mv.addObject("errorMsg", e.getMessage());
        mv.setViewName("errorPage");
        System.out.println("在resolver里面的错误信息是"+e.getMessage());
        return mv;
    }
}
