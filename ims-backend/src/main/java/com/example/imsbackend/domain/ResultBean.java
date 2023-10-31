package com.example.imsbackend.domain;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.example.imsbackend.enums.HttpMessage;

/**
 * @author Silvery
 * @since 2023/10/31 15:09
 */
public record ResultBean<T>(Integer code, String message, T data) {

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(HttpMessage.SUCCESS.getCode(), HttpMessage.SUCCESS.getMessage(), data);
    }

    public static <T> ResultBean<T> failure(Integer code, String message) {
        return new ResultBean<>(code, message, null);
    }

    public static <T> ResultBean<T> failure(HttpMessage httpMessage) {
        return new ResultBean<>(httpMessage.getCode(), httpMessage.getMessage(), null);
    }

    public String toJsonString() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
