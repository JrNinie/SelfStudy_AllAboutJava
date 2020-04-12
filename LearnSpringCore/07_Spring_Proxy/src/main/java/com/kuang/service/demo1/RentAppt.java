package com.kuang.service.demo1;

//房客（客户端）访问中介（代理角色）
public class RentAppt {

    public static void main(String[] args) {

        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.visit();
        proxy.rent();
        proxy.fare();

    }
}
