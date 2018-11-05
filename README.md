# boot-dubbo
SpringBoot结合Dubbo的学习示例

# 项目结构
```
|- boot-dubbo
    |- boot-dubbo-api                   服务接口
        |- com
            |- boot
                |- dubbo
                    |- context          实现上下文信息示例
                    |- validation       实现参数验证示例
                    |- async            异步调用示例
                    |- HelloService     基础服务接口
                    |- callback         参数回调示例（服务器端调用客户端）
                    |- event            事件通知示例（客户端调用服务端方法前、后、异常处理）
                    |- mock             本地伪装示例
                    |- stub             本地存根示例
                    |- token            令牌验证
                   
                    
    |- boot-dubbo-consumer              服务消费者
        |- com
            |- boot
                |- dubbo
                    |- cache            实现缓存示例
                    |- context          上下文信息示例
                    |- echo             回声测试示例
                    |- validation       参数验证示例
                    |- async            异步调用示例
                    |- callback         参数回调示例（服务器端调用客户端）                    
                    |- event            事件通知示例（客户端调用服务端方法前、后、异常处理）
                    |- mock             本地伪装示例
                    |- stub             本地存根示例
                    |- token            令牌验证
                   
                    
    |- boot-dubbo-generic-reference     验证泛化调用特性
    
    |- boot-dubbo-provider              服务消费者
        |- com
            |- boot
                |- dubbo
                    |- context           上下文信息示例
                    |- validation        参数验证示例
                    |- async             异步调用示例
                    |- callback          参数回调示例（服务器端调用客户端）
                    |- event            事件通知示例（客户端调用服务端方法前、后、异常处理）
                    |- mock             本地伪装示例
                    |- stub             本地存根示例
                    |- token            令牌验证
                   
    |- boot-dubbo-rest                  实现rest调用
    |- boot-dubbo-spi                   实现基于java的SPI
    |- spring-custom-label              基于spring实现自定义标签
    
```

# 关于rpc-simple模块描述
该模块作为简单rpc实现，用于加深对rpc远程调用的理解
# rpc远程调用原理
- 服务提供者
    - 开放一个端口，用来监听客户端连接
    - 获取ObjectInputStream
    - 获取客户端调用的方法、方法参数类型、方法参数
    - 反射调用目标方法，得到返回结果
    - 获取ObjectOutputStream，输入结果
- 服务消费者
    - 获取与服务器端连接的socket
    - 对调用方法所在的接口实现动态代理
    - 获取ObjectOutputStream
    - 写入要调用的方法名、方法参数类型、方法参数
    - 获取ObjectInputStream
    - 获取返回结果

# Dubbo官网文档注意事项
- rest协议调用
    - 一定要添加注册中心
    ```
    @Bean
    public RegistryConfig registryConfig() {
      RegistryConfig registryConfig = new RegistryConfig();
      registryConfig.setAddress("N/A");
      return registryConfig;
    }
    ```
    - 内置服务器为Tomcat
    ```
    // 配置使用的內置服务
    protocolConfig.setServer("tomcat");
    ```
    - 添加依赖
    ```
    <dependency>
        <groupId>org.jboss.resteasy</groupId>
        <artifactId>resteasy-jaxrs</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.jboss.resteasy</groupId>
        <artifactId>resteasy-jackson-provider</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.jboss.resteasy</groupId>
        <artifactId>resteasy-jaxb-provider</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.jboss.resteasy</groupId>
        <artifactId>resteasy-client</artifactId>
    </dependency>
    ```
- telnet使用
```
telnet localhost 20880,然后一定要敲下回车，打开世界的大门
```
- Qos使用
    - 添加Netty4的依赖
    - 添加Apache Commons Lang3依赖