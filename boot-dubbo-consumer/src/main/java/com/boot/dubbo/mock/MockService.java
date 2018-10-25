package com.boot.dubbo.mock;

/**
 * com.boot.dubbo.mock.MockService
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午10:14
 */
public class MockService implements FooService{
    /**
     * 请注意该类一定要提供无参构造
     * @return
     */
    @Override
    public String testFoo() {
        return null;
    }
}
