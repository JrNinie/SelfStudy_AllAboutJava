package com.kuang.service.demo1;
//真实角色（房东）：被代理的角色（房东被中介所代理）
public class Host implements Rent{

    public void rent() {
        System.out.println("房东把房子出租出去");
    }
}
