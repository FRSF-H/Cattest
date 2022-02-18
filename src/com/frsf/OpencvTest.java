package com.frsf;

import jdk.dynalink.beans.StaticClass;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;


public class OpencvTest {
    public static void main(String[] args) {
    }
    public static String towpic(File file){
        String filename = file.getAbsolutePath();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread(filename);
        Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);
        Imgproc.adaptiveThreshold(image, image, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 25, 10);
        String filename2 = "D:\\carpic\\design\\"+file.getName()+".jpg";
        Imgcodecs.imwrite(filename2, image);
        return filename2;
    }

}