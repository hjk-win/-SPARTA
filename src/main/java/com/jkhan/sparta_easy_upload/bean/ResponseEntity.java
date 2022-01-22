package com.jkhan.sparta_easy_upload.bean;

import com.jkhan.sparta_easy_upload.enumeration.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseEntity
 * @Description ResponseEntity
 * @Author hjk
 * @Date 2022/1/1 21:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> {
    private int code;
    private String message;
    private T body;

    public ResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
    }

    public ResponseEntity(ResponseEnum responseEnum, T body) {
        this.code = responseEnum.getCode();
        this.message = responseEnum.getMessage();
        this.body = body;
    }

}
