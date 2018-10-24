package com.boot.dubbo.context;

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
public class DubboConsumerRpcContextApplication {

    private static RpcContextConsumerService rpcContextConsumerService;

    @Autowired
    public void setRpcContextConsumerService(RpcContextConsumerService rpcContextConsumerService) {
        DubboConsumerRpcContextApplication.rpcContextConsumerService = rpcContextConsumerService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerRpcContextApplication.class, args);
        rpcContextConsumerService.printRpcContextInfo();
    }
}
