package com.boot.dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.HelloConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:33
 */
@Service
public class HelloConsumerService {

    /**
     * 设置结果缓存
     */
    @Reference(cache = "lru")
    private HelloService helloService;

    public String hello(String name) {
        return helloService.hello(name);
    }
}

