package com.boot.dubbo.context;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

/**
 * com.boot.dubbo.context.RpcContextServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午5:51
 */
@Service
public class RpcContextServiceImpl implements RpcContextService{

    @Override
    public void printRpcContextInfo() {
        RpcContext context = RpcContext.getContext();
        boolean isProviderSide = context.isProviderSide();
        String clientIp = context.getRemoteHost();
        String application = context.getUrl().getParameter("application");
        System.out.println("客户端传递的隐式参数======>" + context.getAttachment("index"));
        System.out.println("当前端是否为服务提供者======>" + isProviderSide);
        System.out.println("调用端的ip地址======>" + clientIp);
        System.out.println("当前服务应用名称======>" + application);
    }
}
