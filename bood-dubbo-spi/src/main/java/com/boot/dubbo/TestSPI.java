package com.boot.dubbo;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * com.boot.dubbo.TestSPI
 *
 * @author lipeng
 * @dateTime 2018/11/3 下午3:11
 */
public class TestSPI {

    public static void main(String[] args) {
        ServiceLoader<HelloService> serviceLoader = ServiceLoader.load(HelloService.class);
        Iterator<HelloService> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            iterator.next().hello("测试");
        }
    }
}
