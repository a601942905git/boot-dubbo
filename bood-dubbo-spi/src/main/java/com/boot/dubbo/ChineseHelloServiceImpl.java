package com.boot.dubbo;

/**
 * com.boot.dubbo.ChineseHelloService
 *
 * @author lipeng
 * @dateTime 2018/11/3 下午3:07
 */
public class ChineseHelloServiceImpl implements HelloService {

    @Override
    public void hello(String name) {
        System.out.println("你好：" + name);
    }
}
