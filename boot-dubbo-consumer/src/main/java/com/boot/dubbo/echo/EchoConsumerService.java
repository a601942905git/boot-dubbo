package com.boot.dubbo.echo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.dubbo.HelloService;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.EchoTestService
 *
 * @author lipeng
 * @dateTime 2018/10/22 下午8:40
 */
@Service
public class EchoConsumerService {

    @Reference
    private HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }
}
