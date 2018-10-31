package com.boot.dubbo.response;

import com.boot.dubbo.Customer;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * com.boot.dubbo.response.CustomerResponse
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午7:51
 */
@Data
@XmlRootElement
public class CustomerResponse implements Serializable {

    private Customer customer;
}
