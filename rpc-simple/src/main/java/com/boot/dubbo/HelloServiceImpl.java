package com.boot.dubbo;

/**
 * com.boot.dubbo.HelloServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/28 下午7:44
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello," + name;
    }
}
