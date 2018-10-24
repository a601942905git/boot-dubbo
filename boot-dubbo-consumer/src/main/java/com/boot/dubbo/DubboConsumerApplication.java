package com.boot.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.boot.dubbo.echo.EchoConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * com.boot.dubbo.DubboConsumerApplication
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:35
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerApplication {

    private static EchoConsumerService echoConsumerService;

    private static HelloConsumerService helloConsumerService;

    @Autowired
    public void setHelloConsumerService(HelloConsumerService helloConsumerService) {
        DubboConsumerApplication.helloConsumerService = helloConsumerService;
    }

    @Autowired
    public void setEchoConsumerService(EchoConsumerService echoConsumerService) {
        DubboConsumerApplication.echoConsumerService = echoConsumerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);

        System.out.println(echoConsumerService);
        // 普通接口调用
        System.out.println(helloConsumerService.hello("dubbo-application-consumer"));
    }
}
