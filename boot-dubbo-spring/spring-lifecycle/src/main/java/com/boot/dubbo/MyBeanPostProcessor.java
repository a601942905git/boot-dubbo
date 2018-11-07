package com.boot.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * com.boot.dubbo.MyBeanPostProcessor
 *
 * @author lipeng
 * @dateTime 2018/11/6 下午6:34
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }

    /**
     * 对属性进行修改
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (Objects.equals(beanName, "person")) {
            System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        }
        return bean;
    }

    /**
     * 对属性进行修改
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        if (Objects.equals(beanName, "person")) {
            System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        }
        return bean;
    }
}
