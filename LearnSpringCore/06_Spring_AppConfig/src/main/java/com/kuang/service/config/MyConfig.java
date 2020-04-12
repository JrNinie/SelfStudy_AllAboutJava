package com.kuang.service.config;

import com.kuang.service.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
//这种是纯java的方式去做配置，不再需要xml文件了


//Configuration本身自己也是@Component的，
// 指明自己是配置类，相当于之前的bean.xml(applicationContext.xml)
@Configuration
@ComponentScan("com.kuang.pojo")
@Import(MyConfig2.class)
public class MyConfig {

    //@Bean相当于之前在xml文件里的<bean>标签
    @Bean
    //方法名user1就相当于id
    //返回类型User,就相当于bean标签里面的class属性
    public User user1(){
        return  new User();
    }

}
