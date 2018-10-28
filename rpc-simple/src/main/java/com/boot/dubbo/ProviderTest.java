package com.boot.dubbo;

import java.io.IOException;

/**
 * com.boot.dubbo.ProviderTest
 *
 * @author lipeng
 * @dateTime 2018/10/28 下午7:44
 */
public class ProviderTest {

    public static void main(String[] args) throws IOException {
        RpcFramework.export(new HelloServiceImpl(), 1234);
        RpcFramework.export(new BarServiceImpl(), 12345);
        for (; ; ) {

        }
    }
}
