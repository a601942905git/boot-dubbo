package com.boot.dubbo.token;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.boot.dubbo.stub.DubboConsumerStubApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.boot.dubbo.token.DubboConsumerTokenApplication
 *
 * @author lipeng
 * @dateTime 2018/10/26 下午7:04
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerTokenApplication {

    private static TokenConsumerService tokenConsumerService;

    @Autowired
    public void setTokenConsumerService(TokenConsumerService tokenConsumerService) {
        DubboConsumerTokenApplication.tokenConsumerService = tokenConsumerService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerStubApplication.class, args);
        tokenConsumerService.testToken();
    }
}
