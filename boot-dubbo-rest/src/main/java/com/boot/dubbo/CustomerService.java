package com.boot.dubbo;

import com.boot.dubbo.response.BaseResponse;
import com.boot.dubbo.response.CustomerListResponse;
import com.boot.dubbo.response.CustomerResponse;

/**
 * com.boot.dubbo.CustomerService
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午7:50
 */
public interface CustomerService {

    CustomerListResponse listCustomer();

    CustomerResponse getCustomer(Integer id);

    BaseResponse saveCustomer(Customer customer);

    BaseResponse modifyCustomer(Integer id, Customer customer);
}
