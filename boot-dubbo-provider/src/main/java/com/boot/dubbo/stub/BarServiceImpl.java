package com.boot.dubbo.stub;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * com.boot.dubbo.stub.StubServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午5:53
 */
@Service
public class BarServiceImpl implements BarService {

    @Override
    public void testStub() {
        System.out.println("服务提供者开始执行业务逻辑代码......");
    }
}
