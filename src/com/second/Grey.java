package com.second;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgproc.Imgproc.cvtColor;

public class Grey {
    public static void ToGrey(){
        Mat src = Imgcodecs.imread(FileChoose.File_Place+"\\Guass\\"+FileChoose.File_Name);
        cvtColor(src,src, Imgproc.COLOR_BGR2GRAY);
        Imgcodecs.imwrite(FileChoose.File_Place+"\\Guass\\Grey\\"+FileChoose.File_Name,src);
    }
}
