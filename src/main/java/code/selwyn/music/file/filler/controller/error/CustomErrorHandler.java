/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.controller.error;

import code.selwyn.music.file.filler.result.Result;
import code.selwyn.music.file.filler.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Class: CustomErrorHandler
 * User: Selwyn<br/>
 * Date: 6/11/2018<br/>
 * Time: 4:51 PM<br/>
 * Desp: 错误统一处理
 */
@ControllerAdvice
@Slf4j
public class CustomErrorHandler {

    /** 
    * @Description: 异常处理 
    * @Param:  
    * @return:  
    * @Author: Selwyn
    * @Date: 6/11/2018 
    */ 
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result restErrorHandler(HttpServletRequest req, Exception e) throws Exception
    {
        String reqUrl = req.getRequestURI();
        log.error("Request url: {}, Error Msg: {}, Exception: {}",
                reqUrl, e.getMessage(), e);
        return ResultUtil.fromException(e);
    }

}
