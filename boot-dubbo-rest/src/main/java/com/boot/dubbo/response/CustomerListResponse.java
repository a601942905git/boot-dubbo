package com.boot.dubbo.response;

import com.boot.dubbo.Customer;
import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * com.boot.dubbo.response.CustomerListResponse
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午7:51
 */
@Data
@ToString
@XmlRootElement
public class CustomerListResponse implements Serializable {

    private List<Customer> customerList;
}
