package com.boot.dubbo.callback;

/**
 * com.boot.dubbo.callback.CallbackService
 *
 * @author lipeng
 * @dateTime 2018/10/24 下午10:03
 */
public interface CallbackService {

    void addListener(String key, CallbackListener callbackListener);
}
