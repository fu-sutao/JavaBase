package com.fst.utils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class TuPian {

    public static void getBufferImage() throws Exception {
        File file = new File("D:/a.jpg");

//        System.out.println(file.isFile());
        BufferedImage bufImage = ImageIO.read(file);
//        BufferedImage bufImage = ImageIO.read(URL input);
//        BufferedImage bufImage = ImageIO.read(InputStream input);

//      创建空图片
        BufferedImage bufImage2 = new BufferedImage(50, 30, BufferedImage.TYPE_3BYTE_BGR);
        System.out.println(bufImage2.getWidth());
        saveImageToLocalDir(bufImage2,file.getPath());
        System.out.println("------"+bufImage.getWidth());
        System.out.println(bufImage2.getWidth());



    }

    /**
     *
     * 1、 输出图片到本地目录
     * @param buffImg 图片  BufferedImage
     * @param savePath 本地目录的路径
     */
    public static void  saveImageToLocalDir(BufferedImage buffImg, String savePath) {
        try {
            ImageIO.write(buffImg, "png", new File(savePath));

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
