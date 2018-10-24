package com.boot.dubbo;

/**
 * com.boot.dubbo.HelloService
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:06
 */
public interface HelloService {

    String hello(String name);

    Person getPerson(Person person);
}
