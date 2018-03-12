package com.ustbyjy.file;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ustbyjy
 * Date: 2017/3/3
 * Time: 9:44
 */
public class FileTest {

    /**
     * mkdir方法不会创建必要的父目录，若父目录不存在，则创建失败返回false
     * mkdirs方法会创建必要但不存在的父目录
     */
    @Test
    public void mkDirTest() {
        File file = new File("C:\\export\\logs\\daily-study\\" + UUID.randomUUID());
        if (!file.exists()) {
            boolean result = file.mkdir();
            System.out.println("mkdir方法是否创建成功：" + result);
        }
        if (!file.exists()) {
            boolean result = file.mkdirs();
            System.out.println("mkdirs方法是否创建成功：" + result);
        }
    }

    @Test
    public void compareFileTest() throws Exception {
        File file1 = new File("D:\\PlatformSVN\\gmt\\trunk\\GMPlatform\\src\\main\\webapp\\WEB-INF\\assets\\js\\custom\\mail_gz.js");
        File file2 = new File("D:\\PlatformSVN\\gmt\\trunk\\GMPlatform\\src\\main\\webapp\\WEB-INF\\assets\\js\\custom\\mail_mhzx.js");
        BufferedReader bf1 = new BufferedReader(new FileReader(file1));
        BufferedReader bf2 = new BufferedReader(new FileReader(file2));
        while (true) {
            String file1Line = bf1.readLine();
            String file2Line = bf2.readLine();
            System.out.println(file1Line);
            if (file1Line != null && file2Line == null || file1Line == null && file2Line != null || file1Line != null && file2Line != null && !file1Line.trim().equals(file2Line.trim())) {
                System.out.println("Two files is not the same.");
                break;
            }
            if (file1Line == null && file2Line == null) {
                System.out.println("The scanning is completed.");
            }
        }
    }

    @Test
    public void testWriteFile() {
        try {
            File file = new File("new.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            System.out.println(file.getName());
            FileOutputStream fos = new FileOutputStream(file);
            String content = "Hello!!!";
            fos.write(content.getBytes());
//            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCharset() throws IOException {
        String parentPath = getClass().getClassLoader().getResource("").getPath();
        System.out.println(parentPath);
        File file = new File(parentPath, "test.xml");
        String content = FileUtils.readFileToString(file);
        System.out.println(content);
    }


}
