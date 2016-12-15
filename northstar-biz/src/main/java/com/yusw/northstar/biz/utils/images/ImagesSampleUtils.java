package com.yusw.northstar.biz.utils.images;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */
public class ImagesSampleUtils {

    public static void main(String[] args) throws Exception, Exception{
        File file = new File("E:\\test_img");
        List<String> list = getFilesPath(file);
        for (String str:list ) {
            printImageTags(new File(str));
        }
    }
    public static List<String> getFilesPath(File file){
        List<String> listPath = new ArrayList<String>();
        File[] files = file.listFiles();
        for (int i=0;i<files.length;i++){
            if(files[i].isDirectory()){
                getFilesPath(files[i]);
            }
            //System.out.println(i+" - "+files[i].getAbsolutePath());
            listPath.add(files[i].getAbsolutePath());
        }
        return listPath;
    }
    public static void printImageTags(File file) throws ImageProcessingException, Exception{
        Metadata metadata = ImageMetadataReader.readMetadata(file);
        System.out.println(file.getName());
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                 String tagName = tag.getTagName();  //标签名
                 String desc = tag.getDescription(); //标签信息
                 if (tagName.equals("Image Height")) {
                     System.out.println("图片高度: "+desc);
                 } else if (tagName.equals("Image Width")) {
                     System.out.println("图片宽度: "+desc);
                 } else if (tagName.equals("Date/Time Original")) {
                     System.out.println("拍摄时间: "+desc);
                 }else if (tagName.equals("GPS Latitude")) {
                    //System.err.println("纬度 : "+desc);
                    System.err.println("纬度(度分秒格式) : "+pointToLatlong(desc));
                 } else if (tagName.equals("GPS Longitude")) {
                     //System.err.println("经度: "+desc);
                    System.err.println("经度(度分秒格式): "+pointToLatlong(desc));
                 }
             }
        }
        System.out.println("------------------");
     }
         /**
           * 经纬度格式  转换为  度分秒格式 ,如果需要的话可以调用该方法进行转换
           * @param point 坐标点
           * @return
          */
    public static String pointToLatlong (String point ) {
        Double du = Double.parseDouble(point.substring(0, point.indexOf("°")).trim());
        Double fen = Double.parseDouble(point.substring(point.indexOf("°")+1, point.indexOf("'")).trim());
        Double miao = Double.parseDouble(point.substring(point.indexOf("'")+1, point.indexOf("\"")).trim());
        Double duStr = du + fen / 60 + miao / 60 / 60 ;
        return duStr.toString();
    }
}
