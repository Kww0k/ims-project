package com.example.imsbackend.handler;

import com.example.imsbackend.domain.ResultBean;
import com.example.imsbackend.enums.HttpMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import static com.example.imsbackend.constants.HttpStatus.HTTP_STATUS_422;

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
        if (e instanceof ConstraintViolationException exception)
            return ResultBean.failure(HTTP_STATUS_422, exception.getMessage());
        if (e instanceof MethodArgumentNotValidException exception)
            if (exception.getFieldError() != null)
                return ResultBean.failure(HTTP_STATUS_422, exception.getFieldError().getDefaultMessage());
        if (e instanceof BindException exception)
            return ResultBean.failure(HTTP_STATUS_422, exception.getMessage());
        return ResultBean.failure(HttpMessage.SYSTEM_ERROR);
    }
}
