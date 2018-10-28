package com.boot.dubbo;

/**
 * com.boot.dubbo.BarServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/28 下午8:14
 */
public class BarServiceImpl implements BarService {

    @Override
    public String hello(String name) {
        return "【BarService】Hello," + name;
    }
}
