package com.yusw.northstar.biz.utils.images;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import javax.imageio.ImageReader;
import javax.imageio.ImageTranscoder;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/6.
 */
public class AAA {
    /**
     * 图片信息获取metadata元数据信息
     * @param fileName 需要解析的文件
     * @return
     */
    public ImgInfoVO parseImgInfo (String fileName) {
        File file = new File(fileName);
        ImgInfoVO imgInfoVO = null;
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            imgInfoVO = printImageTags(file, metadata);
        } catch (ImageProcessingException e) {
            System.err.println("error 1a: " + e);
        } catch (IOException e) {
            System.err.println("error 1b: " + e);
        }
        return imgInfoVO;
    }

    /**
     * 读取metadata里面的信息
     * @param sourceFile 源文件
     * @param metadata metadata元数据信息
     * @return
     */
    private ImgInfoVO printImageTags(File sourceFile, Metadata metadata)
    {
        ImgInfoVO imgInfoVO = new ImgInfoVO ();
        imgInfoVO.setImgSize(sourceFile.getTotalSpace());
        imgInfoVO.setImgName(sourceFile.getName());
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                String tagName = tag.getTagName();
                String desc = tag.getDescription();
                if (tagName.equals("Image Height")) {
                    //图片高度
                    imgInfoVO.setImgHeight(desc);
                } else if (tagName.equals("Image Width")) {
                    //图片宽度
                    imgInfoVO.setImgWidth(desc);
                } else if (tagName.equals("Date/Time Original")) {
                    //拍摄时间
                    imgInfoVO.setDateTime(desc);
                } else if (tagName.equals("GPS Altitude")) {
                    //海拔
                    imgInfoVO.setAltitude(desc);
                } else if (tagName.equals("GPS Latitude")) {
                    //纬度
                    imgInfoVO.setLatitude(pointToLatlong(desc));
                } else if (tagName.equals("GPS Longitude")) {
                    //经度
                    imgInfoVO.setLongitude(pointToLatlong(desc));
                }
            }
            for (String error : directory.getErrors()){
                System.err.println("ERROR: " + error);
            }
        }
        return imgInfoVO;
    }

    /**
     * 经纬度转换  度分秒转换
     * @param point 坐标点
     * @return
     */
    public String pointToLatlong (String point ) {
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°")+1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'")+1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60 ;
        return duStr.toString();
    }

    public static void main(String[] args) {
        String fileName = "E:\\test_img\\aaa.JPG";
        ImgInfoVO imgInfoVO = new AAA().parseImgInfo(fileName);
        System.out.println(imgInfoVO.toString());
        imgInfoVO.setLongitude("106.6757104939");//jing
        imgInfoVO.setLatitude("26.6200042939");//weidu
        System.out.println(imgInfoVO.toString());


    }

}
