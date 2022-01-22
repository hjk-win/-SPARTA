package com.jkhan.sparta_easy_upload.exception;

/**
 * @ClassName FileException
 * @Description FileException
 * @Author hjk
 * @Date 2022/1/18 20:58
 **/
public class FileException extends CommonException{
    static final long serialVersionUID = 1L;

    public FileException(String description) {
        super(description);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    public FileException(String description, Throwable cause) {
        super(description, cause);
    }

    public FileException(int code, String description, String type) {
        super(code, description, type);
    }
}
