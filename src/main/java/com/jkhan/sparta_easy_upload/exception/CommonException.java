package com.jkhan.sparta_easy_upload.exception;

/**
 * @ClassName CommonException
 * @Description CommonException
 * @Author hjk
 * @Date 2022/1/1 21:28
 **/
public class CommonException extends Exception {
    static final long serialVersionUID = 1L;

    private int code;
    private String description;
    private String type;

    public CommonException(String description) {
        super(description);
    }
    public CommonException(Throwable cause) {
        super(cause);
    }
    public CommonException(String description, Throwable cause) {
        super(description, cause);
    }
    public CommonException(int code, String description, String type) {
        this.code = code;
        this.description = description;
        this.type = type;
    }

}
