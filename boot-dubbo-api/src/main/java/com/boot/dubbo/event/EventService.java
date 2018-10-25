package com.boot.dubbo.event;

import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.EventService
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午3:46
 */
public interface EventService {

    Person get(Integer id);

    Person getByMultiParameter(Integer id, String name);
}
