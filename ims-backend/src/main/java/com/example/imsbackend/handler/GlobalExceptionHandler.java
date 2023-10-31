package com.example.imsbackend.handler;

import com.example.imsbackend.domain.ResultBean;
import com.example.imsbackend.enums.HttpMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Silvery
 * @since 2023/10/31 15:19
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultBean<Void> exceptionHandler(Exception e) {
        if (e instanceof GlobalException exception)
            return ResultBean.failure(exception.getCode(), exception.getMessage());
        return ResultBean.failure(HttpMessage.SYSTEM_ERROR);
    }
}
