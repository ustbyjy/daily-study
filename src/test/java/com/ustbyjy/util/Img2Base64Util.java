package com.ustbyjy.util;

import org.apache.commons.codec.binary.Base64;

import java.io.*;


/**
 * 将图片转换为Base64<br>
 * 将base64编码字符串解码成img图片
 */
public class Img2Base64Util {

    public static void main(String[] args) {
        String imgFile = "doc/1.jpg";//待处理的图片
        String imgBase = getImgStr(imgFile);
        System.out.println(imgBase.length());
        System.out.println(imgBase);
        String imgFilePath = "doc/2.jpg";//新生成的图片
        String s = "iVBORw0KGgoAAAANSUhEUgAAAJIAAAAyCAYAAAC3Z4JgAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NDc4MzA5MEQ5NzNDMTFFNTk5MEFDNjY3RDZFNDFCMTEiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NDc4MzA5MEU5NzNDMTFFNTk5MEFDNjY3RDZFNDFCMTEiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo0NzgzMDkwQjk3M0MxMUU1OTkwQUM2NjdENkU0MUIxMSIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo0NzgzMDkwQzk3M0MxMUU1OTkwQUM2NjdENkU0MUIxMSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/PkcA4FsAABE1SURBVHja7F0JmBTF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";
        generateImage(s, imgFilePath);
    }

    /**
     * 将图片转换成Base64编码
     *
     * @param imgFile 待处理图片
     * @return
     */
    public static String getImgStr(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(Base64.encodeBase64(data));
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     *
     * @param imgStr      图片数据
     * @param imgFilePath 保存图片全路径地址
     * @return
     */
    public static boolean generateImage(String imgStr, String imgFilePath) {
        //
        if (imgStr == null) //图像数据为空
            return false;
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}