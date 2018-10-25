package com.boot.dubbo.event;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.EventServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午3:47
 */
@Service
public class EventServiceImpl implements EventService {

    @Override
    public Person get(Integer id) {
        return new Person(id, "testEventNotify");
    }

    @Override
    public Person getByMultiParameter(Integer id, String name) {
        return new Person(id, name);
    }
}
