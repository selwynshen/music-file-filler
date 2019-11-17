/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.controller;

import code.selwyn.music.file.filler.data.FillingResult;
import code.selwyn.music.file.filler.handler.MusicNameHandler;
import code.selwyn.music.file.filler.result.Result;
import code.selwyn.music.file.filler.result.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Selwyn
 * @version $Id: MusicFileController.java, v 0.1 11/4/2018 5:19 PM Selwyn Exp $
 */
@RestController
@Slf4j
@RequestMapping("/music/file")
public class MusicFileController {

    @Autowired
    private MusicNameHandler musicNameHandler;

    @PostMapping("/names")
    public Result<List<FillingResult>> doFilling(@ModelAttribute("directory")String directory) throws Exception
    {
        List<FillingResult> fillingResultList = this.musicNameHandler.handleMusicName(directory);
        return ResultUtil.createSuccessResult(fillingResultList);
    }
}
