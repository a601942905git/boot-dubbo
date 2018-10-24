package com.boot.dubbo.cache;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.boot.dubbo.HelloConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * com.boot.dubbo.validation.DubboValidationApplication
 *
 * @author lipeng
 * @dateTime 2018/10/19 下午5:07
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerCacheApplication {

    private static HelloConsumerService helloConsumerService;

    @Autowired
    public void setHelloConsumerService(HelloConsumerService helloConsumerService) {
        DubboConsumerCacheApplication.helloConsumerService = helloConsumerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerCacheApplication.class, args);
        for (int i = 0; i < 10; i++) {
            System.out.println(helloConsumerService.hello("dubbo-cache-consumer"));
        }
    }
}
