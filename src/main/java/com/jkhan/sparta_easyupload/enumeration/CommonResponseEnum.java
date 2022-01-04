package com.jkhan.sparta_easyupload.enumeration;

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
