/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.handler;

import code.selwyn.music.file.filler.data.FillingResult;
import code.selwyn.music.file.filler.exception.BizException;
import code.selwyn.music.file.filler.util.MusicUtil;
import code.selwyn.music.file.filler.util.MyMusicLibrary;
import com.daioware.file.FileUtil;
import com.daioware.music.Artist;
import com.daioware.music.MusicLibrary;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Selwyn
 * @version $Id: MusicNameHandler.java, v 0.1 11/4/2018 3:58 PM Selwyn Exp $
 */
@Component
@Slf4j
public class MusicNameHandler {
    /**
     * 歌星名-歌曲名
     */
    private static final String SONG_NAME_TEMPLATE = "%s-%s";

    /**
     * 处理音乐文件名称修改
     * @param directory
     * @throws Exception
     */
    public List<FillingResult> handleMusicName(String directory) throws Exception
    {
        File folder = new File(directory);
        if (!folder.exists()) {
            throw new BizException("no such path exists");
        }
        if (!folder.isDirectory()) {
            throw new BizException("directory not exists");
        }
        //MusicLibrary lib = new MusicLibrary(folder, MusicUtil.getDefaultMusicExtensions());
        //lib.loadLibrary();
        MyMusicLibrary lib = new MyMusicLibrary(folder, MusicUtil.getDefaultMusicExtensions());
        Map<File, Artist> artistMap = lib.loadSingle();

        ArrayList<File> songFiles = FileUtil.getFiles(folder, lib.getMusicExtensions());
        List<FillingResult> resultList = new ArrayList<>();

        for (Map.Entry<File, Artist> entry : artistMap.entrySet())
        {
            File file = entry.getKey();
            Artist artist =
                    entry.getValue();
            if (artist == null || artist.getAlbum(0) == null) {
                continue;
            }
            String extension = FilenameUtils.getExtension(file.getName());

            try{
                String targetName =
                        String.format(SONG_NAME_TEMPLATE, artist.getName(), artist.getAlbum(0).getSong(0).getName());
                //System.out.println(String.format("%s->%s", file.getName(), targetName));
                targetName = targetName + "." + extension;
                String newFileName = file.getParent() + File.separator + targetName;
                File newFile = new File(newFileName);
                //System.out.println(newFile.getPath());
                file.renameTo(newFile);
                resultList.add(new FillingResult(file.getName(), targetName));
            }catch(Exception e){
                throw e;
            }
        }

        return resultList;
    }

}
