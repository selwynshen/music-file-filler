/**
 * hzmmy.cn Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.controller;

import code.selwyn.music.file.filler.handler.LrcEncodingHandler;
import code.selwyn.music.file.filler.result.Result;
import code.selwyn.music.file.filler.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Selwyn
 * @version $Id: LrcFileController.java, v 0.1 11/17/2019 10:15 AM Selwyn Exp $
 */
@RestController
@Slf4j
@RequestMapping("/lrc/file")
public class LrcFileController {

    @Autowired
    private LrcEncodingHandler lrcEncodingHandler;

    @PostMapping("/encoding")
    public Result<Integer> doFilling(@ModelAttribute("directory")String directory) throws Exception
    {
        return ResultUtil.createSuccessResult(this.lrcEncodingHandler.changeEncoding(directory));
    }

}
