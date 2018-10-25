package com.boot.dubbo.event;

import com.boot.dubbo.Person;

/**
 * com.boot.dubbo.event.NotifyServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/25 下午3:49
 */
public class NotifyServiceImpl implements NotifyService {

    @Override
    public void onInvoke(Integer id) {
        System.out.println("方法调用【方法调用之前执行】");
        System.out.println("oninvoke[id]:" + id);
    }

    @Override
    public void onReturn(Person msg, Integer id) {
        System.out.println("方法调用【方法调用完成执行】");
        System.out.println("onreturn[id]:" + id);
        System.out.println("onreturn[person]:" + msg);
    }

    @Override
    public void onThrow(Throwable ex, Integer id) {
        System.out.println(ex.getCause());
        System.out.println("方法调用【异常通知方法执行】");
    }
}

