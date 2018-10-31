package com.boot.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * com.boot.dubbo.DubboRestApplicaton
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午10:43
 */
@SpringBootApplication
@DubboComponentScan(basePackages = {"com.boot.dubbo"})
public class DubboRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRestApplication.class, args);
    }
}
