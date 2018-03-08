package com.ustbyjy.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateBlackImage {

    public static void main(String[] args) throws IOException {
        int width = 1920;
        int height = 1080;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, width, height);
        graphics.dispose();

        ImageIO.write(bufferedImage, "JPEG", new File("D:\\QMDownload\\壁纸\\5.jpg"));
    }
}
