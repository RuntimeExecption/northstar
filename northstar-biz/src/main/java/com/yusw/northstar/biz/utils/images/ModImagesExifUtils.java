package com.yusw.northstar.biz.utils.images;
import net.sourceforge.jheader.App1Header;
import net.sourceforge.jheader.JpegHeaders;
import net.sourceforge.jheader.TagValue;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by Administrator on 2016/11/6.
 */
public class ModImagesExifUtils {
    public static void main(String[] args) throws Exception {
        String filename = "E:\\test_img\\aaa.JPG";
        JpegHeaders jpegHeaders = new JpegHeaders(filename);
        // EXIF
        App1Header exifHeader = jpegHeaders.getApp1Header();
        // 遍历显示EXIF
        SortedMap<App1Header.Tag, TagValue> tags = exifHeader.getTags();
        for (Map.Entry entry: tags.entrySet()) {
            System.out.println(entry.getKey() + "[" + entry.getKey() + "]:" + entry.getValue());
        }
        // 修改EXIF的拍照日期
        exifHeader.setValue(App1Header.Tag.DATETIMEORIGINAL,filename);
        // 保存
        jpegHeaders.save(true);
    }
}
