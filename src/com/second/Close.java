package com.second;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.core.*;

import static org.opencv.imgproc.Imgproc.*;


public class Close {
    public static void ToClose(){
        Mat src = Imgcodecs.imread(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\"+FileChoose.File_Name);
        Mat kernel = getStructuringElement(MORPH_RECT,new Size(17,3));
        morphologyEx(src,src,MORPH_CLOSE,kernel);

        medianBlur(src, src, 5);       //平滑处理，中值滤波
        Imgcodecs.imwrite(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\Close\\"+FileChoose.File_Name,src);
    }
}
