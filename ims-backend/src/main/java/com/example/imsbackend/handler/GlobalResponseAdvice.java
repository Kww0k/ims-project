package com.example.imsbackend.handler;

import com.example.imsbackend.domain.ResultBean;
import com.example.imsbackend.enums.HttpMessage;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author Silvery
 * @since 2023/10/31 15:17
 */
@RestControllerAdvice
public class GlobalResponseAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Boolean flag)
            if (!flag)
                return ResultBean.failure(HttpMessage.SYSTEM_ERROR);
        if (body instanceof ResultBean)
            return body;
        if (body instanceof String)
            return ResultBean.success(body).toJsonString();
        return ResultBean.success(body);
    }
}
