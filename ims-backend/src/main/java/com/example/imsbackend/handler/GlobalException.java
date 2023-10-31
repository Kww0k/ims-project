package com.example.imsbackend.handler;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Silvery
 * @since 2023/10/31 17:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GlobalException extends RuntimeException{

    protected Integer code;

    protected String message;

    public GlobalException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
