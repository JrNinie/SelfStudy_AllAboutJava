package com.kuang.service.demo2;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        UserServiceImplProxy proxy = new UserServiceImplProxy();
        proxy.setUserService(userService);
        proxy.add();//调用了 add 方法 //增加了用户


    }
}
