/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Selwyn
 * @version $Id: IndexController.java, v 0.1 11/4/2018 4:58 PM Selwyn Exp $
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }
}
