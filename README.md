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
                  
                    
    |- boot-dubbo-consumer              服务消费者
        |- com
            |- boot
                |- dubbo
                    |- cache            实现缓存示例
                    |- context          上下文信息示例
                    |- echo             回声测试示例
                    |- validation       参数验证示例
                    |- async            异步调用示例
                    
    |- boot-dubbo-generic-reference     验证泛化调用特性
    
    |- boot-dubbo-provider              服务消费者
        |- com
            |- boot
                |- dubbo
                    |- context           上下文信息示例
                    |- validation        参数验证示例
                    |- async             异步调用示例

```