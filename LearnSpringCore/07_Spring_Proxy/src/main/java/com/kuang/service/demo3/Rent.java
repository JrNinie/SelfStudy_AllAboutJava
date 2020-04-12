package com.kuang.service.demo3;

//“租房”这个动作（抽象角色）：一般使用接口或抽象类解决
//这个接口要被房东（真实角色）和房屋中介（代理角色）所实现
public interface Rent {

    public void rent();
}
