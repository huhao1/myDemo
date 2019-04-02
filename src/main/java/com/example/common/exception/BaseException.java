package com.example.common.exception;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author hao
 * @Date 2019/3/28 16:35
 **/
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 419239556160503410L;

    public BaseException(String message) {
        super(message);
    }

}
