package com.kuang.service;

//案例要求：在执行每个方法的时候增加日志gongn
//那么为了不改动原来的代码，就需要增加这个类的代理proxy
public class UserServiceImpl implements UserService{

    public void add() {
        System.out.println("增加了用户");
    }

    public void delete() {
        System.out.println("删除了用户");
    }

    public void update() {
        System.out.println("更新了用户");
    }

    public void find() {
        System.out.println("找到了用户");
    }
}
