package com.kuang.service.pojo;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hello hello = (Hello) o;
        return Objects.equals(greeting, hello.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greeting);
    }

    @Override
    public String toString() {
        return "Hello{" +
                "greeting='" + greeting + '\'' +
                '}';
    }
}
