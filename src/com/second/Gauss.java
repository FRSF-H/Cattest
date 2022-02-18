package com.second;

import org.opencv.core.*;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.Imgproc;
public class Gauss {

    public static void ToGauss() {
        try{
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat src=Imgcodecs.imread(FileChoose.File_Path);
            //读取图像到矩阵中
            if(src.empty()){
                throw new Exception("no file");
            }
            Mat dst = src.clone();
            //复制矩阵进入dst
            Imgproc.GaussianBlur(src,dst,new Size(3,3),0,0);
            //图像模糊化处理11
            Imgcodecs.imwrite(FileChoose.File_Place+"\\Guass\\"+FileChoose.File_Name, dst);
        }catch(Exception e){
            System.out.println("例外：" + e);
        }
    }
}