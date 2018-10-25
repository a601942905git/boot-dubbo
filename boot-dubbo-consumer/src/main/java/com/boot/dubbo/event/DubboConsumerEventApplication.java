package com.boot.dubbo.event;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * com.boot.dubbo.DubboConsumerApplication
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:35
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
@ImportResource(locations = {"classpath:spring-consumer.xml"})
public class DubboConsumerEventApplication {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        DubboConsumerEventApplication.applicationContext = applicationContext;
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DubboConsumerEventApplication.class, args);
        EventService eventService = (EventService) applicationContext.getBean("eventService");
        eventService.get(4);
        eventService.getByMultiParameter(4, "eventNotity");
    }
}
