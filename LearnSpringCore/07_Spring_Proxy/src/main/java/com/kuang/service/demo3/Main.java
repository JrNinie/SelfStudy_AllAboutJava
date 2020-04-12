package com.kuang.service.demo3;

public class Main {

    public static void main(String[] args) {
        //真实角色：房东
        Host host = new Host();

        //代理角色:动态生成
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setRent(host);
        Rent proxy = (Rent)proxyInvocationHandler.getProxy();
        proxy.rent();
    }
}
