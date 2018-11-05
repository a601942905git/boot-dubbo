package com.boot.dubbo;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * com.boot.dubbo.PersonBeanDefinitionParser
 *
 * @author lipeng
 * @dateTime 2018/11/5 下午5:12
 */
public class PersonBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Person.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder bean) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");

        if (StringUtils.hasText(id)) {
            bean.addPropertyValue("id", id);
        }

        if (StringUtils.hasText(name)) {
            bean.addPropertyValue("name", name);
        }

        if (StringUtils.hasText(age)) {
            bean.addPropertyValue("age", age);
        }
    }
}
