package com.jkhan.sparta_easyupload.bean;

import lombok.Data;

/**
 * @ClassName ResponseEntity
 * @Description ResponseEntity
 * @Author hjk
 * @Date 2022/1/1 21:04
 **/
@Data
public class ResponseEntity<T> {
    private int code;
    private String message;
    private T body;

    public ResponseEntity() {

    }

    public ResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(int code, String message, T body) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

}
