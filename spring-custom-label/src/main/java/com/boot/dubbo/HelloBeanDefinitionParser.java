package com.boot.dubbo;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * com.boot.dubbo.HelloBeanDefinitionParser
 *
 * @author lipeng
 * @dateTime 2018/11/5 下午5:58
 */
public class HelloBeanDefinitionParser implements BeanDefinitionParser {

    private final Class<?> beanClass;

    public HelloBeanDefinitionParser(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        return parse(element, parserContext, beanClass);
    }

    private BeanDefinition parse(Element element, ParserContext parserContext, Class<?> beanClass) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(beanClass);
        beanDefinition.setLazyInit(false);

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");

        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        beanDefinition.getPropertyValues().addPropertyValue("name", name);

        // 注册bean
        parserContext.getRegistry().registerBeanDefinition(id, beanDefinition);

        return beanDefinition;
    }
}
