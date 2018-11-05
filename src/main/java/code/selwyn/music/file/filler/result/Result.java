/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.result;

import lombok.Data;

/**
 * 统一返回数据模型
 * @author Selwyn
 * @version $Id: Result.java, v 0.1 10/9/2018 4:02 PM Selwyn Exp $
 */
@Data
public class Result<T> {

    /** 是否处理成功 */
    private boolean           success        = false;

    /** 返回码 */
    private Integer            code = -1;

    /**返回信息*/
    protected String          message = "";

    /**要返回的数据类型*/
    private T                 data;
}
