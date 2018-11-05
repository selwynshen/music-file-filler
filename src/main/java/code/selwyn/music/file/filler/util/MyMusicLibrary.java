/**
 * hzmmy.com Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.util;

import com.daioware.file.FileUtil;
import com.daioware.music.Album;
import com.daioware.music.Artist;
import com.daioware.music.MusicLibrary;
import com.daioware.music.Song;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Selwyn
 * @version $Id: MyMusicLibrary.java, v 0.1 11/4/2018 10:03 PM Selwyn Exp $
 */
@Slf4j
public class MyMusicLibrary extends MusicLibrary {

    private List<File> songFiles;

    public MyMusicLibrary(File folder, ArrayList<String> musicExts) {
        super(folder, musicExts);
        this.songFiles = FileUtil.getFiles(getFolder(),getMusicExtensions());
    }

    /**
     * 加载和处理音频信息（社会主义改造，一个音频文件只有一个artist信息）
     * @return
     * @throws Exception
     */
    public Map<File, Artist> loadSingle() throws Exception
    {
        Map<File, Artist> resultMap = new HashMap<>();
        Artist tempArtist;
        for(File songFile : songFiles) {
            try{
                tempArtist = this.handleSongFile(songFile);
            }catch(Exception e){
                log.info("failed to handle song file: {}", songFile.getPath(), e);
                continue;
            }
            resultMap.put(songFile, tempArtist);
        }
        return resultMap;
    }

    /**
     * 单个音频文件信息解析
     * @param songFile
     * @return
     * @throws Exception
     */
    private Artist handleSongFile(File songFile) throws Exception
    {
        Song song;
        Artist artist;
        Album album;
        song=new Song(songFile);
        artist=new Artist(song.getArtistName());
        album=new Album(artist, song.getAlbumName());
        album.addSong(song);
        artist.addAlbum(album);
        return artist;
    }

}
