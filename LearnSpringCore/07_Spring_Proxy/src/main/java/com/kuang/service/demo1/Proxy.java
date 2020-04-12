package com.kuang.service.demo1;

public class Proxy implements Rent {

    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
    }

    //代理角色的附属操作：看房
    public void visit(){
        System.out.println("中介带你参观房子");
    }

    //代理角色的附属操作：收房租
    public void fare(){
        System.out.println("中介收费用");
    }

}
