package com.boot.dubbo.mock;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * com.boot.dubbo.mock.MockServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午10:07
 */
@Service
public class FooServiceImpl implements FooService {

    @Override
    public String testFoo() {
        try {
            // 以此来模拟服务提供者超时，服务调用这可以出发mock
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "execute testMock method";
    }
}
