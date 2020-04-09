package com.kuang.dao;

/*
没有spring之前的方法:
业务层service和数据层dao是各司其职的
 */
public class UserDaoMysqlImpl implements UserDao {

    public void getUser() {
        System.out.println("Mysql方式：打印user信息");
    }
}
