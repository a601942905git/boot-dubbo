package com.boot.dubbo.token;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * com.boot.dubbo.token.TokenServiceImpl
 *
 * @author lipeng
 * @dateTime 2018/10/26 下午7:01
 */
@Service(token = "true")
public class TokenServiceImpl implements TokenService {

    @Override
    public void testToken() {
        System.out.println("令牌验证方法执行");
    }
}
