package com.boot.dubbo;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.boot.dubbo.response.BaseResponse;
import com.boot.dubbo.response.CustomerListResponse;
import com.boot.dubbo.response.CustomerResponse;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * com.boot.dubbo.CustomerServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/29 下午7:55
 */
@Path("customers")
@Produces(ContentType.APPLICATION_JSON_UTF_8)
public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(10001, "test1", 22));
        customerList.add(new Customer(10002, "test2", 23));
        customerList.add(new Customer(10003, "test3", 24));
        customerList.add(new Customer(10004, "test4", 25));
        customerList.add(new Customer(10005, "test5", 26));
    }

    @Path("/")
    @GET
    @Override
    public CustomerListResponse listCustomer() {
        CustomerListResponse customerListResponse = new CustomerListResponse();
        customerListResponse.setCustomerList(customerList);
        return customerListResponse;
    }

    @Path("{id: \\d+}")
    @GET
    @Override
    public CustomerResponse getCustomer(@PathParam("id") Integer id) {
        Optional<Customer> customerOptional = customerList.stream().filter(customer -> Objects.equals(customer.getId(), id)).findFirst();
        Customer customer = customerOptional.orElseGet(() -> new Customer(10006, "测试Dubbo-rest协议", 66));
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomer(customer);
        return customerResponse;
    }

    @POST
    @Override
    public BaseResponse saveCustomer(Customer customer) {
        customerList.add(customer);
        return BaseResponse.success();
    }

    @Path("{id: \\d+}")
    @POST
    @Override
    public BaseResponse modifyCustomer(@PathParam("id") Integer id, Customer customer) {
        Optional<Customer> customerOptional = customerList.stream().filter(customer1 -> Objects.equals(customer.getId(), id)).findFirst();
        Customer customer2 = customerOptional.orElseGet(() -> new Customer(10006, "测试Dubbo-rest协议", 66));
        customerList.remove(customer2);
        customerList.add(customer);
        return BaseResponse.success();
    }
}
