package com.kuang.service.pojo;

public class Student {

    private String name;

    public Student() {
        System.out.println("在Student的无参构造函数中");
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
