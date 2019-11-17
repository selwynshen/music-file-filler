/**
 * hzmmy.cn Inc.
 * Copyright (c) 2013-2066 All Rights Reserved.
 */
package code.selwyn.music.file.filler.handler;

import code.selwyn.music.file.filler.exception.BizException;
import code.selwyn.music.file.filler.util.MusicUtil;
import com.daioware.file.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.mozilla.universalchardet.UniversalDetector;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * @author Selwyn
 * @version $Id: LrcEncodingHandler.java, v 0.1 11/17/2019 10:17 AM Selwyn Exp $
 */
@Component
@Slf4j
public class LrcEncodingHandler {

    /**
     * lrc文件转成utf-8编码
     * @param directory
     * @return
     */
    public Integer changeEncoding(String directory) {
        File folder = new File(directory);
        if (!folder.exists()) {
            throw new BizException("no such path exists");
        }
        if (!folder.isDirectory()) {
            throw new BizException("directory not exists");
        }

        ArrayList<File> lrcFiles = FileUtil.getFiles(folder, MusicUtil.getDefaultLyricExtensions());
        int counter = 0;
        for (File lrcFile : lrcFiles) {
            try{
                String charset = UniversalDetector.detectCharset(lrcFile);
                //已经是utf-8则不需要处理了
                if (charset != null && "utf-8".equalsIgnoreCase(charset)) {
                    continue;
                }
                //检测工具无法检测到gb2312，因此认为编码就是gb2312
                charset = Charset.forName("gb2312").name();
                String fileContent = FileUtils.readFileToString(lrcFile, charset);
                FileUtils.deleteQuietly(lrcFile);
                FileUtils.writeStringToFile(lrcFile, fileContent, "utf-8");
                counter++;
            }catch(Exception e){
                log.error("文件转码失败: {}", lrcFile.getPath(), e);
            }
        }
        return counter;
    }

}
