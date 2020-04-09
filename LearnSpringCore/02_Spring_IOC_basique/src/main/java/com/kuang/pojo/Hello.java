package com.kuang.pojo;

public class Hello {

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    //这里的setter方法是必须的，否则报错
    // Bean property 'greeting' is not writable or has an invalid setter method
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
