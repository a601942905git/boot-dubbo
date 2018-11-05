package com.boot.dubbo;

/**
 * com.boot.dubbo.EnglishHelloService
 *
 * @author lipeng
 * @dateTime 2018/11/3 下午3:07
 */
public class EnglishHelloServiceImpl implements HelloService {

    @Override
    public void hello(String name) {
        System.out.println("Hello：" + name);
    }
}
