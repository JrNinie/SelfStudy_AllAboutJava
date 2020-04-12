package com.kuang.service.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//默认实例化的名字就是类名小写首字母
@Component
public class User {

    //给属性赋值，简单的方便，但是如果属性比较复杂还是建议使用xml配置
    @Value("LUCIE")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
