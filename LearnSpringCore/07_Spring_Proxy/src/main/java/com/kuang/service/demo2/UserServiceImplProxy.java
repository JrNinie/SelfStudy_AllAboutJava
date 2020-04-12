package com.kuang.service.demo2;

public class UserServiceImplProxy implements UserService{

    private UserService userService = new UserServiceImpl();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        doLog("add");
        userService.add();
    }

    public void delete() {
        doLog("delete");
        userService.delete();
    }

    public void update() {
        userService.update();
    }

    public void find() {
        doLog("find");
        userService.find();
    }

    public void doLog(String str){
        System.out.println("调用了 "+str+" 方法");
    }
}
