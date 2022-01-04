package com.jkhan.sparta_easyupload.exception;

/**
 * @ClassName BusinessException
 * @Description BusinessException
 * @Author hjk
 * @Date 2022/1/1 22:35
 **/
public class BusinessException extends CommonException {
    static final long serialVersionUID = 1L;

    public BusinessException(String description) {
        super(description);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String description, Throwable cause) {
        super(description, cause);
    }

    public BusinessException(int code, String description, String type) {
        super(code, description, type);
    }
}
