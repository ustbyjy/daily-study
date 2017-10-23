package com.ustbyjy.io;

import org.apache.commons.io.*;
import org.apache.commons.io.monitor.FileEntry;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ustbyjy@163.com
 * Date: 2017/3/3
 * Time: 10:30
 */
public class CommonIOTest {
    private static final String PARENT_DIR = CommonIOTest.class.getClassLoader().getResource("").getPath();
    private static final String EXAMPLE_TEXT_PATH = PARENT_DIR + "example.txt";

    @Test
    public void filenameUtilsTest() {
        // 得到绝对路径
        System.out.println("Full path of exampleTxt: " + FilenameUtils.getFullPath(EXAMPLE_TEXT_PATH));
        // 得到文件名
        System.out.println("Full name of exampleTxt: " + FilenameUtils.getName(EXAMPLE_TEXT_PATH));
        // 得到扩展名(后缀)
        System.out.println("extension of exampleTxt: " + FilenameUtils.getExtension(EXAMPLE_TEXT_PATH));
        // 得到去掉后缀的文件名
        System.out.println("Base name of exampleTxt: " + FilenameUtils.getBaseName(EXAMPLE_TEXT_PATH));
    }

    @Test
    public void fileUtilsTest() throws Exception {
        File exampleFile = FileUtils.getFile(EXAMPLE_TEXT_PATH);
        LineIterator lineIterator = FileUtils.lineIterator(exampleFile);
        while (lineIterator.hasNext()) {
            System.out.println(lineIterator.next());
        }
        lineIterator.close();
    }

    @Test
    public void ioCaseTest() {
        String str1 = "This is a new String.";
        String str2 = "This is another new String, yes!";

        System.out.println("Ends with string (case sensitive): " + IOCase.SENSITIVE.checkEndsWith(str1, "string."));
        System.out.println("Ends with string (case sensitive): " + IOCase.INSENSITIVE.checkEndsWith(str1, "string."));

        System.out.println("String equality: " + IOCase.SENSITIVE.checkEquals(str1, str2));
    }

    @Test
    public void fileSystemUtilsTest() throws IOException {
        System.out.println("Free disk space (in KB): " + FileSystemUtils.freeSpaceKb("C:"));
        System.out.println("Free disk space (in MB): " + FileSystemUtils.freeSpaceKb("C:") / 1024);
        System.out.println("Free disk space (in GB): " + FileSystemUtils.freeSpaceKb("C:") / (1024 * 1024));
    }

    @Test
    public void fileMonitorTest() {
        FileEntry entry = new FileEntry(FileUtils.getFile(EXAMPLE_TEXT_PATH));
        System.out.println("File monitored: " + entry.getFile());
        System.out.println("File name: " + entry.getName());
        System.out.println("Is exists? " + entry.isExists());
        System.out.println("Is the file a directory? " + entry.isDirectory());
    }
}
