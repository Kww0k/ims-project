package com.example.imsbackend.enums;

import lombok.Getter;

import static com.example.imsbackend.constants.HttpStatus.*;

/**
 * @author Silvery
 * @since 2023/10/31 15:11
 */
@Getter
public enum HttpMessage {

    SUCCESS(HTTP_STATUS_200, "操作成功"),
    USERNAME_PASSWORD_EXCEPTION(HTTP_STATUS_401, "用户名或密码错误"),
    LOGOUT_ERROR(HTTP_STATUS_401, "登出时出现异常"),
    INSERT_STUDENT_ERROR(HTTP_STATUS_500, "新增学生信息时出现异常"),
    DELETE_STUDENT_ERROR(HTTP_STATUS_500, "删除学生信息时出现异常"),
    SYSTEM_ERROR(HTTP_STATUS_500, "未知错误");

    final Integer code;

    final String message;


    HttpMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
