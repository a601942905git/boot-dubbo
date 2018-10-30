package com.boot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * com.boot.dubbo.DubboRestApplicaton
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午10:43
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring-rest.xml"})
public class DubboRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRestApplication.class, args);
    }
}
