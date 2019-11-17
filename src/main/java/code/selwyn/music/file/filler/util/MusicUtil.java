/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.util;

import java.util.ArrayList;

/**
 * @author Selwyn
 * @version $Id: Util.java, v 0.1 11/4/2018 4:07 PM Selwyn Exp $
 */
public class MusicUtil {

    public static ArrayList<String> getDefaultMusicExtensions() {
        ArrayList<String> exts =
                com.daioware.music.Util.getDefaultMusicExtensions();
        exts.add("flac");
        exts.add("ape");
        return exts;
    }

    public static ArrayList<String> getDefaultLyricExtensions() {
        ArrayList<String> exts = new ArrayList<>();
        exts.add("lrc");
        return exts;
    }
}
