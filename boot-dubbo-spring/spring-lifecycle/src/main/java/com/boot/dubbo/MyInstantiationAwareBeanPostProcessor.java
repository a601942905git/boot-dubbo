package com.boot.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.Objects;

/**
 * com.boot.dubbo.MyInstantiationAwareBeanPostProcessor
 *
 * @author lipeng
 * @dateTime 2018/11/6 下午6:34
 */
@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    /**
     * 接口方法、实例化Bean之前调用
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class beanClass,
                                                 String beanName) throws BeansException {
        if (Objects.equals(beanName, "person")) {
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法");
        }
        return null;
    }

    /**
     * 接口方法、实例化Bean之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (Objects.equals(beanName, "person")) {
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法");
        }
        return bean;
    }

    /**
     * 接口方法、设置某个属性时调用
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {
        if (Objects.equals(beanName, "person")) {
            System.out.println("InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法");
        }
        return pvs;
    }
}
