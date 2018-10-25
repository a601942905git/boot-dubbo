package com.boot.dubbo.mock;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.mock.MockComsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午10:06
 */
@Service
public class FooCustomerService {

    @Reference(mock = "com.boot.dubbo.mock.MockService")
    private FooService fooService;

    public String testMock() {
        return fooService.testFoo();
    }
}
