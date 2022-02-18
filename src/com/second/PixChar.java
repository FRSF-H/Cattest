package com.second;
import org.opencv.core.Mat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;
/**
 * @author  FRSF
 * 2021年10月13日 17点27分
 * mats     分割的车牌单字符容器
 * 完成字模读取    21点45分
 *
 * 2021年10月14日 15点21分
 * 完成个人字符集的创建及录入Mysql
 * 完成字模录入    20点12分
 */
public class PixChar {
    public static void ToChar() {
//        Scanner scanner = new Scanner(System.in);
//        Connection connection = com.frsf.mysql.getConnection();      //本包使用mysql类
//        String sql = "insert into word (name,data1,data2,data3,data4,data5,data6,data7,data8,data9,data10,data11," +
//                "data12,data13,data14,data15,data16,data17,data18,data19,data20,data21,data22," +
//                "data23,data24,data25,data26,data27,data28) values (?,?,?,?,?,?,?,?,?,?,?,?," +
//                "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Vector<Mat> mats = GetPix.toChar;
        Mat img = mats.get(6);
        int jilie = img.width();        //行数
        int jihang = img.height();      //列数
        int ch = img.channels();        //通道数 (灰度: 1, RGB: 3, etc.)
        System.out.println(jilie + " " + jihang);
        byte[] temp = new byte[ch*jilie*jihang];
        img.get(0,0,temp);
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
        int[] get_word = new int[28];            //提取的字符集容器
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

//        System.out.println();
//        System.out.print("输入字模信息: ");
//        String hanzi = scanner.next();
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1,hanzi);
//            for(int i=0;i<28;i++){
//                statement.setInt(i+2,get_word[i]);
//            }
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}

