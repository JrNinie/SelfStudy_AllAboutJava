package com.kuang.service.pojo;

public class User {

    private String name;

    public User() {
        System.out.println("使用User的无参构造函数");
    }

    public User(String name) {
        System.out.println("使用User的有参构造函数");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showName(){
        System.out.println("使用showname方法：" + name);
    }

}
