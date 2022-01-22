package com.jkhan.sparta_easy_upload.util;

import com.jkhan.sparta_easy_upload.exception.BusinessException;

/**
 * @ClassName AssertUtil
 * @Description AssertUtil
 * @Author hjk
 * @Date 2022/1/4 21:24
 **/
public class AssertUtil {
    private AssertUtil() {
    }

    public static void notNull(Object object, String message) throws BusinessException {
        if (object == null) {
            throw new BusinessException(message);
        }
    }
}
