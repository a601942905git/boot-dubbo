package com.boot.dubbo.callback;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.callback.CallbackConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午10:10
 */
@Service
public class CallbackConsumerService {

    @Reference
    private CallbackService callbackService;

    public void testCallback() {
        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", msg -> System.out.println("callback1:" + msg));
    }
}
