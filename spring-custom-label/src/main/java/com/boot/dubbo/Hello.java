package com.boot.dubbo;

import lombok.Data;
import lombok.ToString;

/**
 * com.boot.dubbo.Hello
 *
 * @author lipeng
 * @dateTime 2018/11/5 下午5:55
 */
@Data
@ToString
public class Hello {

    private String id;

    private String name;


    public String hello() {
        return "hello," + this.name;
    }
}
