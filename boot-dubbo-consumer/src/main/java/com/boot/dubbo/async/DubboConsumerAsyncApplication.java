package com.boot.dubbo.async;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.ExecutionException;

/**
 * com.boot.dubbo.validation.DubboValidationApplication
 *
 * @author lipeng
 * @dateTime 2018/10/19 下午5:07
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerAsyncApplication {

    private static AsyncConsumerService asyncConsumerService;

    @Autowired
    public void setAsyncConsumerService(AsyncConsumerService asyncConsumerService) {
        DubboConsumerAsyncApplication.asyncConsumerService = asyncConsumerService;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(DubboConsumerAsyncApplication.class, args);
        asyncConsumerService.testAsyncMethod();
    }
}
