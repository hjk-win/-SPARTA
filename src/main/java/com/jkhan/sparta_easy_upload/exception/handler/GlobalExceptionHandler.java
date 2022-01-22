package com.jkhan.sparta_easy_upload.exception.handler;

import com.jkhan.sparta_easy_upload.bean.ResponseEntity;
import com.jkhan.sparta_easy_upload.enumeration.ResponseEnum;
import com.jkhan.sparta_easy_upload.exception.BusinessException;
import com.jkhan.sparta_easy_upload.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description GlobalExceptionHandler
 * @Author hjk
 * @Date 2022/1/1 21:22
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Object handleBusinessException(BusinessException e) {
        log.error("BusinessException: {}", e.getMessage(), e);
        return new ResponseEntity<>(ResponseEnum.FAILURE, e.getMessage());
    }

    @ExceptionHandler(CommonException.class)
    public Object handelCommonException(CommonException e) {
        log.error("CommonException: {}", e.getMessage(), e);
        return new ResponseEntity<>(ResponseEnum.FAILURE, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Object handleRuntimeException(RuntimeException e) {
        log.error("RuntimeException: {}", e.getMessage(), e);
        return new ResponseEntity<>(500, "Internal server error...") ;
    }
}
