package com.itcast.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {

    //HandlerInterceptor没有强制重写方法，自己去里面找的
    /*
    如果返回true，继续下面的handler，如果没有，去controller
    返回false，不去controller
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("in preHandler");
        //可以加入条件判断，进行页面跳转
        request.getRequestDispatcher("/WEB-INF/pages/errorPage.jsp").forward(request, response);
        return true;
    }

}
