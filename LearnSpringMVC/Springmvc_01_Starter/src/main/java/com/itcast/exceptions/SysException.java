package com.itcast.exceptions;

public class SysException extends Exception {

    private String message;

    public SysException(String message) {
        this.message = message;
    }

    //这里必须有setter getter方法，否则无法得到message
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
