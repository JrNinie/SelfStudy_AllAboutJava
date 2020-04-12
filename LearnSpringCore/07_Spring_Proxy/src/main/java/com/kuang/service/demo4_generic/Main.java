package com.kuang.service.demo4_generic;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setTarget(userService);
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
    }
}
