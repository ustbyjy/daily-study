package com.ustbyjy.file;

import org.junit.Test;

import java.io.File;
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
}
