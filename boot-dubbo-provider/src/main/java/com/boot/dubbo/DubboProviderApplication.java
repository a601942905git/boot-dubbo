package com.boot.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * com.boot.dubbo.DubboProviderApplication
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:14
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
