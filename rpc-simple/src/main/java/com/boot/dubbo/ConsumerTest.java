package com.boot.dubbo;

/**
 * com.boot.dubbo.ConsumerTest
 *
 * @author lipeng
 * @dateTime 2018/10/28 下午7:45
 */
public class ConsumerTest {

    public static void main(String[] args) {
        HelloService helloService = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
        System.out.println(helloService.hello("simpleRpcTest"));

        BarService barService = RpcFramework.refer(BarService.class, "127.0.0.1", 12345);
        System.out.println(barService.hello("simpleRpcTest"));
    }
}
