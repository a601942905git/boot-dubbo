package com.boot.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * com.boot.dubbo.HelloServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:08
 */
@Service(timeout = 5000)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        System.out.println("客户端隐式参数======>" + RpcContext.getContext().getAttachment("index"));
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }

    @Override
    public Person getPerson(Person person) {
        System.out.println("服务调用者传递过来的编号为：" + person.getId());
        System.out.println("服务调用者传递过来的名称为：" + person.getName());
        Person person1 = new Person();
        person1.setId(10002);
        person1.setName("服务接口返回名称");
        return person1;
    }
}
