/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.result;

import code.selwyn.music.file.filler.exception.BizException;

/**
 * 统一返回数据模型 工具类
 * 已废弃，请用 {@link Result}
 * @author Selwyn
 * @version $Id: ResultUtil.java, v 0.1 10/10/2018 10:58 AM Selwyn Exp $
 */
public class ResultUtil {
    /**
     * 固定默认异常码 9999  系统繁忙
     */
    private static final int DEF_ERROR_CODE = 9999;

    private static final String DEF_ERROR_MESSAGE = "System Busy";

    public static <T> Result<T> createSuccessResult(T t)
    {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setData(t);
        return result;
    }

    public static <T> Result<T> createFailedResult(int code, String message, T t)
    {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        result.setData(t);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> fromException(Exception e, T t)
    {
        int code = DEF_ERROR_CODE;
        String message = DEF_ERROR_MESSAGE;
        if (e instanceof BizException) {
            BizException bizException = (BizException)e;
            message = e.getMessage();
        }
        return createFailedResult(code, message, t);
    }

    public static Result<Void> fromException(Exception e)
    {
        return fromException(e, null);
    }
}
