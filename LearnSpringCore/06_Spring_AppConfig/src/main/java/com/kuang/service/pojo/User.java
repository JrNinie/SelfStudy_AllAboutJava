package com.kuang.service.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Value("Sandrine")
    private String name;

    public String getName() {
        return name;
    }
}
