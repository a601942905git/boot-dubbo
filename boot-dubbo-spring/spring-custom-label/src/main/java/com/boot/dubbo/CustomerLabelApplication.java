package com.boot.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

/**
 * com.boot.dubbo.CustomerLabelApplication
 *
 * @author lipeng
 * @dateTime 2018/11/5 下午5:18
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:custom-label.xml"})
public class CustomerLabelApplication {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        CustomerLabelApplication.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerLabelApplication.class, args);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        System.out.println("=====================华丽分割线=======================");

        Hello hello = (Hello) applicationContext.getBean("hello");
        System.out.println(hello.hello());

    }
}
