package com.kuang.service.dao;

/*
没有spring之前的方法:
业务层service和数据层dao是各司其职的
 */
public class UserDaoImpl implements UserDao {
    public void getUser() {
        System.out.println("默认方式：打印user信息");
    }
}
