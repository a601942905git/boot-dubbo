package com.boot.dubbo.echo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.rpc.service.EchoService;
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
public class DubboConsumerEchoApplication {

    private static EchoConsumerService echoConsumerService;

    @Autowired
    public void setEchoConsumerService(EchoConsumerService echoConsumerService) {
        DubboConsumerEchoApplication.echoConsumerService = echoConsumerService;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerEchoApplication.class, args);

        EchoService echoService = (EchoService) echoConsumerService.getHelloService();

        for (int i = 0; i < 100; i++) {
            System.out.println(echoService.$echo("OK" + i));
            Thread.sleep(1000);
        }
    }
}
