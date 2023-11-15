package com.example.imsbackend.handler.exception;

import com.example.imsbackend.handler.GlobalException;

import static com.example.imsbackend.enums.HttpMessage.DELETE_STUDENT_ERROR;

/**
 * @author Silvery
 * @since 2023/11/16 02:18
 */
public class DeleteStudentException extends GlobalException {
    public DeleteStudentException() {
        super(DELETE_STUDENT_ERROR.getCode(), DELETE_STUDENT_ERROR.getMessage());
    }
}
