package com.second;
import org.opencv.core.*;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Scalar;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.CvType.CV_8UC1;
import static org.opencv.core.CvType.depth;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.*;
import static org.opencv.imgproc.Imgproc.rectangle;
import org.opencv.core.Mat;

/**
 * @author
 * Mat src      获取轮廓图像
 * Mat test     原图像，用于绘制识别的车牌区域最小外围正矩形
 * Mat getmat   原图像，用于下步截取作背板
 * Mat mat      截取的车牌图像
 */

public class Find {
    public static void ToFind() {
        Mat src = imread(FileChoose.File_Place + "\\Guass\\Grey\\Sobel\\Two\\Close\\" + FileChoose.File_Name, CV_8UC1);
        List<MatOfPoint> contours = new ArrayList<>();
        Mat hierarchy = new Mat();
        findContours(src, contours, hierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE);

        //筛选轮廓
        //Mat background = new Mat(src.size(), CvType.CV_8UC1, new Scalar(0));
        Mat test = imread(FileChoose.File_Path);
        for (int i = 0; i < contours.size(); i++) {
            Rect rect = boundingRect(contours.get(i));
            double w = rect.width;
            double h = rect.height;
            int x=0,y=0,x1 = 0,y1=0;
            if(((float)rect.width / rect.height >= 2.5)){
                if ( (contourArea(contours.get(i)) > 2000)&&(contourArea(contours.get(i)) < 8000))  {
                    if(SizeJudge.ToSize(contours.get(i))&&rect.x<400&&rect.x>50) {
                        System.out.println("车牌尺寸："+rect.size());
                        //Rect rect1 = boundingRect(contours.get(i));
                        x=rect.x;y=rect.y;x1=rect.width;y1=rect.height;

                        //最小外接矩形
                        MatOfPoint point=contours.get(i);
                        MatOfPoint2f point2f=new MatOfPoint2f(point.toArray());
                        RotatedRect rect1 =minAreaRect(point2f);

                        Point rectPoint[] = new Point[4];
                        rect1.points(rectPoint);
                        double angle = rect1.angle;
                        Point center = rect1.center;

                        //rectangle(test,rect1.boundingRect(), new Scalar(255));
                        System.out.println("角度："+rect1.angle);
                        //绘制外接正矩形
                        rectangle(test, new Point(rect.x,rect.y),new Point(rect.x + rect.width, rect.y + rect.height),new  Scalar(255), 2, 8);
                        //drawContours(background, contours, i, new Scalar(255), 1);
                        Mat getmat = imread(FileChoose.File_Path);
                        System.out.println("车牌定位："+x+" "+y+" "+x1+" "+y1);

                        //截取矩形
                        Rect getrect = new Rect(x+6,y+5,x1-17,y1-12);
                        Mat mat = new Mat(getmat,getrect);
                        Imgcodecs.imwrite(FileChoose.File_Place + "\\Guass\\Grey\\Sobel\\Two\\Close\\Find\\Get\\" + FileChoose.File_Name,mat);

                    }
                }
            }
            //HighGui.imshow("ces", background);
            //HighGui.waitKey(5);
            Imgcodecs.imwrite(FileChoose.File_Place + "\\Guass\\Grey\\Sobel\\Two\\Close\\Find\\" + FileChoose.File_Name, test);

        }
    }
}
