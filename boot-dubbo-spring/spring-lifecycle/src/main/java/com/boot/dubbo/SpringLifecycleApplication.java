package com.boot.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * com.boot.dubbo.SpringLifecycleApplication
 *
 * @author lipeng
 * @dateTime 2018/11/6 下午6:23
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring-lifecycle.xml"})
public class SpringLifecycleApplication {

    public static void main(String[] args) {
        System.out.println("============准备初始化容器============");
        ApplicationContext applicationContext = SpringApplication.run(SpringLifecycleApplication.class, args);
        System.out.println("============容器初始化完成============");

        System.out.println("============准备开始关闭容器============");
        ((ConfigurableApplicationContext) applicationContext).registerShutdownHook();
    }
}
