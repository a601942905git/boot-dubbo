package com.boot.dubbo.validation;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.validation.ValidationConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/19 上午11:18
 */
@Service
public class ValidationConsumerService {

    @Reference(validation = "true")
    private ValidationService validationService;

    public void save(ValidationParameter validationParameter) {
        validationService.save(validationParameter);
    }

    public void update(ValidationParameter validationParameter) {
        validationService.update(validationParameter);
    }
}
