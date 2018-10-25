package com.boot.dubbo.mock;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.boot.dubbo.DubboConsumerApplication
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:35
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerMockApplication {

    private static FooCustomerService mockCustomerService;

    @Autowired
    public void setMockCustomerService(FooCustomerService mockCustomerService) {
        DubboConsumerMockApplication.mockCustomerService = mockCustomerService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerMockApplication.class, args);
        System.out.println("调用服务返回结果：" + mockCustomerService.testMock());
    }
}
