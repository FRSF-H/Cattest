package com.second;

import org.opencv.core.MatOfPoint;

public class SizeJudge {
    public static boolean ToSize(MatOfPoint mr){
        double error = 0.3;
        double aspect = 3.142857;   //China car plate size: 440mm*140mm，aspect 3.142857

        int min = (int) (1*aspect*2000);
        int max = (int) (2000*aspect*2000);

        double rmin = aspect-aspect*error;
        double rmax = aspect+aspect*error;

        int area = mr.height() * mr.width();
        double r = (double)mr.width()/(double) mr.height();
        if (r < 1) {
            r = (double)mr.height()/(double) mr.width();
        }
        if((area < min || area > max) || (r < rmin || r > rmax))
            return true;
        else
            return false;

    }
}
