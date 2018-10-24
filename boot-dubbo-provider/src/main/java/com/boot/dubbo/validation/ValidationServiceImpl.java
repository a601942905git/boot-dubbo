package com.boot.dubbo.validation;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * com.boot.dubbo.validation.ValidationServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/19 下午1:44
 */
@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public void save(ValidationParameter validationParameter) {
        System.out.println("保存参数校验......");
    }

    @Override
    public void update(ValidationParameter validationParameter) {
        System.out.println("修改参数校验......");
    }
}
