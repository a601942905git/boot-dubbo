package com.boot.dubbo.event;

import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.MultiParameterNotifyServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午5:16
 */
public class MultiParameterNotifyServiceImpl implements MultiParameterNotifyService {

    @Override
    public void onInvoke(Integer id, String name) {
        System.out.println("oninvoke[id]:" + id + "[name]:" + name);
    }

    @Override
    public void onReturn(Person msg, Integer id, String name) {
        System.out.println("onreturn[id]:" + id + "[name]:" + name);
        System.out.println("onreturn[person]:" + msg);
    }

    @Override
    public void onThrow(Throwable ex, Integer id, String name) {
        System.out.println("onthrow[id]:" + id + "[name]:" + name);
    }
}
