package com.boot.dubbo.response;

import lombok.*;

/**
 * com.boot.dubbo.response.BaseResponse
 *
 * @author lipeng
 * @dateTime 2018/10/30 上午9:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BaseResponse<T> {

    private String code;

    private String message;

    private T result;

    public static BaseResponse success() {
        BaseResponse baseResponse = BaseResponse.builder()
                .code("1")
                .message("操作成功")
                .build();

        return baseResponse;
    }

    public static BaseResponse fail() {
        BaseResponse baseResponse = BaseResponse.builder()
                .code("-1")
                .message("操作失败")
                .build();

        return baseResponse;
    }

}
