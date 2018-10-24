package com.boot.dubbo.context;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.context.RpcContextConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午5:57
 */
@Service
public class RpcContextConsumerService {

    @Reference
    private RpcContextService rpcContextService;
    
    public void printRpcContextInfo() {
        RpcContext context = RpcContext.getContext();

        // 传递隐式参数
        context.setAttachment("index", "1");

        // 调用远程服务
        rpcContextService.printRpcContextInfo();

        boolean isConsumerSide = context.isConsumerSide();
        String serverIp = context.getRemoteHost();
        String application = context.getUrl().getParameter("application");
        System.out.println("当前端是否为服务消费者======>" + isConsumerSide);
        System.out.println("服务端端的ip地址======>" + serverIp);
        System.out.println("当前服务应用名称======>" + application);
    }
}
