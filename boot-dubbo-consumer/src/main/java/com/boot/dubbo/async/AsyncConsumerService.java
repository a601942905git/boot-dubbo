package com.boot.dubbo.async;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * com.boot.dubbo.async.AsyncService
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午7:41
 */
@Service
public class AsyncConsumerService {

    @Reference(async = true)
    private AsyncService asyncService;

    public void testAsyncMethod() throws InterruptedException, ExecutionException {
        asyncService.testAsyncMethod1();
        Future<String> testFuture1 = RpcContext.getContext().getFuture();

        asyncService.testAsyncMethod2();
        Future<String> testFuture2 = RpcContext.getContext().getFuture();

        String testAsyncMethodResult1 = testFuture1.get();
        String testAsyncMethodResult2 = testFuture2.get();

        System.out.println("调用异步测试方法1结果======>" + testAsyncMethodResult1);
        System.out.println("调用异步测试方法2结果======>" + testAsyncMethodResult2);
    }
}
