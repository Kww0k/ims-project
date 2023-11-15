package com.example.imsbackend.handler.exception;

import com.example.imsbackend.handler.GlobalException;

import static com.example.imsbackend.enums.HttpMessage.INSERT_STUDENT_ERROR;

/**
 * @author Silvery
 * @since 2023/11/16 02:15
 */
public class InsertStudentException extends GlobalException {
    public InsertStudentException() {
        super(INSERT_STUDENT_ERROR.getCode(), INSERT_STUDENT_ERROR.getMessage());
    }
}
