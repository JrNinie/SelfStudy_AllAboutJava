package com.jr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//这个Main类必须直接在包名下com.jr.Main.java，不能放在更下面的包下（com.jr.app.Main.java），报错
//因为涉及到扫描包，扫描的是@SpringBootApplication注解所在的包，以及它下面的包

//标注一个主程序类
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        //应用启动起来
        SpringApplication.run(Main.class,args);
    }
}
