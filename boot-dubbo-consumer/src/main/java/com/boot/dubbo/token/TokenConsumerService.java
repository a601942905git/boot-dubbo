package com.boot.dubbo.token;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * com.boot.dubbo.token.TokenConsumerService
 *
 * @author lipeng
 * @dateTime 2018/10/26 下午7:03
 */
@Service
public class TokenConsumerService {

    /**
     * 注释掉的部分可以放开，用来测试启用token验证之后，消费者是无法直连生产者的
     */
    //@Reference(url = "dubbo://localhost:20880")
    @Reference()
    private TokenService tokenService;

    public void testToken() {
        tokenService.testToken();
    }
}
