package com.boot.dubbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * com.boot.dubbo.Customer
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午7:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Customer implements Serializable {

    private Integer id;

    private String name;

    private Integer age;
}
