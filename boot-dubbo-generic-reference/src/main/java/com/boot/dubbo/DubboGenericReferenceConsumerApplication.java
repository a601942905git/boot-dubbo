package com.boot.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

/**
 * com.boot.dubbo.DubboConsumerApplication
 *
 * @author lipeng
 * @dateTime 2018/10/18 上午9:35
 */
@SpringBootApplication
@DubboComponentScan(basePackages = "com.boot.dubbo")
public class DubboGenericReferenceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboGenericReferenceConsumerApplication.class, args);

        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-generic-reference-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        // 该对象需要缓存
        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface("com.boot.dubbo.HelloService");
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setGeneric(true);

        GenericService genericService = referenceConfig.get();

        Object result = genericService.$invoke("hello", new String[] {"java.lang.String"}, new Object[] {"dubbo-generic-reference-consumer"});
        System.out.println("泛化调用hello方法结果======>" + result);

        Map<String, Object> person = new HashMap<>();
        person.put("id", 10001);
        person.put("name", "调用服务名称");
        Object personResult = genericService.$invoke("getPerson", new String[]{"com.boot.dubbo.Person"}, new Object[]{person});
        System.out.println("泛化调用getPerson方法结果======>" +personResult);
    }
}
