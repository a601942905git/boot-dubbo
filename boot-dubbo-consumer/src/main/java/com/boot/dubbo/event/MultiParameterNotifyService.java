package com.boot.dubbo.event;

import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.MutiParameterNotifyService
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午5:15
 */
public interface MultiParameterNotifyService {

    /**
     * 方法调用前
     */
    void onInvoke(Integer id, String name);

    /**
     * 方法调用后
     * @param msg
     * @param id
     */
    void onReturn(Person msg, Integer id, String name);

    /**
     * 方法抛出异常
     * @param ex
     * @param id
     */
    void onThrow(Throwable ex, Integer id, String name);
}
