package com.boot.dubbo.async;

/**
 * com.boot.dubbo.async.AsyncService
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午7:48
 */
public interface AsyncService {

    String testAsyncMethod1() throws InterruptedException;

    String testAsyncMethod2();
}
