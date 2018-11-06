package com.boot.dubbo;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * com.boot.dubbo.PersonNameSpaceHandler
 *
 * @author lipeng
 * @dateTime 2018/11/5 下午4:58
 */
public class CustomNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("person", new PersonBeanDefinitionParser());
        registerBeanDefinitionParser("hello", new HelloBeanDefinitionParser(Hello.class));
    }
}
