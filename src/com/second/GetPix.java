package com.second;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import javax.swing.*;
import java.util.Vector;
/**
 * @author  FRSF
 * 2021年10月13日 08点05分
 * Mat []image  分割字符的图片
 * Mat mat      传入待分割的车牌图片
 * Close           09点45分
 *
 * 2021年10月14日 20点12分
 * 基于列像素的字符分割
 * Close        22点14分
 */
public class GetPix {
    public static Vector<Mat> toChar;
    public static Vector ToGetPix(Mat mat) {
        Vector<Mat> image = new Vector<>();
        Vector<Mat> sort = new Vector<>();
        Vector<ImageIcon> icons = new Vector<>();
        int jilie = mat.width();
        int jihang = mat.height();
        int ch = mat.channels();

        int img_cut = (int) (jilie / 7.5);
        for(int i=0,x=0;i<2;i++,x+=img_cut){
            Rect rect = new Rect(x,0,img_cut,jihang);
            Mat mat1 = new Mat(mat,rect);
            image.add(mat1);
        }
        for(int i=0,x=jilie-img_cut;i<5;i++,x-=img_cut){
            Rect rect = new Rect(x,0,img_cut,jihang);
            Mat mat1 = new Mat(mat,rect);
            sort.add(mat1);
        }
        for(int j=4;j>=0;j--)
            image.add(sort.get(j));

        for(int i=0;i<7;i++){
            Imgcodecs.imwrite(FileChoose.File_Place+"\\second\\next\\"+(i)+".png", image.get(i));
            ImageIcon icon = new ImageIcon(FileChoose.File_Place+"\\second\\next\\"+(i)+".png");
            icons.add(icon);
        }
        toChar=image;

//2021年10月14日20点33分增
        byte[] temp = new byte[ch*jilie*jihang];
        mat.get(0,0,temp);
        for(int i=0,j=1;i<jilie*jihang;i++,j++){
            if(temp[i]!=0) {
                System.out.print(1);
                temp[i]=1;
            }else {
                System.out.print(0);
                temp[i]=0;
            }
            if (j % jilie == 0)
                System.out.println();
        }

        int temp_num=0;
        byte[][] word = new byte[jihang][jilie];    //字符集
        int[] get_word = new int[jilie];            //提取的字符集容器
        for (int i = 0; i < jihang; i++) {
            for (int j = 0; j < jilie; j++) {
                word[i][j]=temp[temp_num];
                temp_num++;
            }
        }

        System.out.print("字模信息: ");
        for(int i=0;i<jilie;i++){
            for(int j=0;j<jihang;j++){
                get_word[i]+=word[j][i];
            }
            System.out.print(get_word[i]+" ");
        }
        return icons;
    }
}

