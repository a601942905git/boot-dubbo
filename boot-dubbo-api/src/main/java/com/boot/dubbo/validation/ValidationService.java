package com.boot.dubbo.validation;

/**
 * com.boot.dubbo.validation.ValidationService
 *
 * @author lipeng
 * @dateTime 2018/10/19 上午11:10
 */
public interface ValidationService {

    @interface Save{}
    void save(ValidationParameter validationParameter);

    void update(ValidationParameter validationParameter);
}
