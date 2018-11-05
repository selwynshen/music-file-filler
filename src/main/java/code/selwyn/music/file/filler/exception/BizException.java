/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.exception;

/**
 * 业务异常基类
 * @author Selwyn
 * @version $Id: BizException.java, v 0.1 10/10/2018 10:52 AM Selwyn Exp $
 */
public class BizException extends RuntimeException{

    public BizException(String message)
    {
        super(message);
    }

    public BizException(Exception e)
    {
        super(e);
    }

}
