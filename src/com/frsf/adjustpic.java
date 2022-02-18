package com.frsf;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class adjustpic {
    /**
     * 缩放图片
     * @param file 需要处理的图片文件
     * @param w    缩放后宽度
     * @param h    缩放后的高度
     * @param path 新图片路径
     * @throws Exception
     */
    public static void zoomImage(File file, int w, int h, String path) throws Exception {
        BufferedImage bufImg = ImageIO.read(file);
        //新生成结果图片
        BufferedImage zoomImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        //缩放 getScaledInstance(width,height,hints)
        zoomImg.getGraphics().drawImage(bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIO.write(zoomImg, "jpg", new File(path));
    }
    public static void rotation(){

    }
}
