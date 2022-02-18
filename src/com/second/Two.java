package com.second;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import static org.opencv.imgproc.Imgproc.*;

public class Two {
    public static void ToTwo(){
        Mat src = Imgcodecs.imread(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\"+FileChoose.File_Name,CvType.CV_8UC1);
        threshold(src, src, 0, 255, THRESH_OTSU+THRESH_BINARY);
        Imgcodecs.imwrite(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\"+FileChoose.File_Name,src);
    }
}
