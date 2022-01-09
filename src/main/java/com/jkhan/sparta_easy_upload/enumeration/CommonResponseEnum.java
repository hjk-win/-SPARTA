package com.jkhan.sparta_easy_upload.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommonResponseEnum {
    SUCCESS(200, "success"),
    FORBIDDEN(403, "no authority"),
    NOT_FOUND(404, "not found"),
    FAILURE(500, "failure");

    private int code;
    private String message;


}
