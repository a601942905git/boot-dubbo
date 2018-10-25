package com.boot.dubbo;

import lombok.Data;

import java.io.Serializable;

/**
 * com.boot.dubbo.Person
 *
 * @author lipeng
 * @dateTime 2018/10/22 下午7:52
 */
@Data
public class Person implements Serializable {

    private Integer id;

    private String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
