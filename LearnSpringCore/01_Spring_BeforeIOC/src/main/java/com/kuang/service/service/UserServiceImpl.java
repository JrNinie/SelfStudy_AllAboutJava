package com.kuang.service.service;

import com.kuang.service.dao.UserDao;

/*
没有spring之前的方法:
业务层service和数据层dao是各司其职的
 */
public class UserServiceImpl implements UserService{

    /* V1：
    之前只有UserDaoImpl一个dao实现类的时候，这样解决，但是如果又扩展了UserDaoJpaImpl呢？
    只能手动把new UserDaoImpl()改成new UserDaoJpaImpl()
    那就要修改代码，太麻烦了（以后还可能出现其他的各种daoimpl啊！）
    所以要转变思路，搞set！看V2
    */
//    private UserDao userDao = new UserDaoImpl();
//    public void getUser() {
//        //业务层调用dao层
//        userDao.getUser();
//    }


    /*V2：
    革命性变革
    有了setUserDao方法，就可以把主动权交出去，以后无论扩展了多少个userDao的impl都可以搞定
    程序员不再去管理对象的创建，系统耦合性降低，这个是IOC的原型
     */
    private UserDao userDao;

    //利用set动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    public void getUser() {
        //业务层调用dao层
        userDao.getUser();
    }



}
