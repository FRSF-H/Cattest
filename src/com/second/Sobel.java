package com.second;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.core.Core.BORDER_DEFAULT;
import static org.opencv.core.Core.convertScaleAbs;
import static org.opencv.core.CvType.CV_16S;


public class Sobel {
    public static void ToSobel(){
        Mat src = Imgcodecs.imread(FileChoose.File_Place+"\\Guass\\Grey\\"+FileChoose.File_Name);
        Mat src1 = new Mat();
        Imgproc.Sobel(src, src1, CV_16S, 1, 0,3,1,1,BORDER_DEFAULT);
        convertScaleAbs(src1, src);     //图像归一化处理，缩小
        Imgcodecs.imwrite(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\"+FileChoose.File_Name,src);
    }
}
