package com.boot.dubbo.event;

import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.Notify
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午3:48
 */
public interface NotifyService {

    /**
     * 方法调用前
     */
    void onInvoke(Integer id);

    /**
     * 方法调用后
     * @param msg
     * @param id
     */
    void onReturn(Person msg, Integer id);

    /**
     * 方法抛出异常
     * @param ex
     * @param id
     */
    void onThrow(Throwable ex, Integer id);
}
