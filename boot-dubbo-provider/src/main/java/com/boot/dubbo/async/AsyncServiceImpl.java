package com.boot.dubbo.async;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * com.boot.dubbo.async.AsyncServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午8:07
 */
@Service(timeout = 15000)
public class AsyncServiceImpl implements AsyncService {

    @Override
    public String testAsyncMethod1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
        }
        System.out.println("异步测试方法一执行完成");
        return "testAsyncMethod1";
    }

    @Override
    public String testAsyncMethod2() {
        System.out.println("异步方法二执行完成");
        return "testAsyncMethod2";
    }
}
