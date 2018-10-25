package com.boot.dubbo.stub;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.stub.StubConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午5:54
 */
@Service
public class BarConsumerService {

    @Reference(stub = "com.boot.dubbo.stub.BarServiceStub")
    private BarService stubServices;

    public void testStubService() {
        stubServices.testStub();
    }
}
