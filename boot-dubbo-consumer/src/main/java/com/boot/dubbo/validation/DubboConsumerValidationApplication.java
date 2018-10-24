package com.boot.dubbo.validation;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * com.boot.dubbo.validation.DubboValidationApplication
 *
 * @author lipeng
 * @dateTime 2018/10/19 下午5:07
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.boot.dubbo")
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboConsumerValidationApplication {

    private static ValidationConsumerService validationConsumerService;

    @Autowired
    public void setValidationConsumerService(ValidationConsumerService validationConsumerService) {
        DubboConsumerValidationApplication.validationConsumerService = validationConsumerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerValidationApplication.class, args);
        ValidationParameter validationParameter = new ValidationParameter();
        // 带参数校验接口调用
        try {
            validationConsumerService.save(validationParameter);
        } catch (ConstraintViolationException e) {
            // 可以拿到一个验证错误详细信息的集合
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println(violations);
        }
    }
}
