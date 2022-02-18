/*
 * Created by JFormDesigner on Sun Oct 03 17:58:34 CST 2021
 */

package com.second;

//import com.jgoodies.forms.factories.*;
//import com.jgoodies.forms.layout.*;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;
import javax.swing.*;

import static com.frsf.adjustpic.zoomImage;
import static org.opencv.core.Core.BORDER_DEFAULT;
import static org.opencv.core.Core.convertScaleAbs;
import static org.opencv.core.CvType.CV_16S;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.imgproc.Imgproc.*;

/**
 * @author 1
 */
public class judge extends JFrame {
    public judge() {
        setResizable(false);
        setVisible(true);
        initComponents();
    }

    private void getpicActionPerformed(ActionEvent e) {
        //上传图片
        File file = FileChoose.getFile(getContentPane());
        System.out.println("文件路径："+file.getAbsolutePath());
        try {
            zoomImage(file, textPane1.getWidth(), textPane1.getHeight(), file.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        textPane1.insertIcon(icon);

        //高斯模糊
        Gauss.ToGauss();
        ImageIcon icon2 = new ImageIcon(FileChoose.File_Place+"\\Guass\\"+FileChoose.File_Name);
        textPane2.insertIcon(icon2);

        //灰度化
        Grey.ToGrey();
        ImageIcon icon3 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\"+FileChoose.File_Name);
        textPane3.insertIcon(icon3);

        //Sobel算子
        Sobel.ToSobel();
        ImageIcon icon4 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\"+FileChoose.File_Name);
        textPane4.insertIcon(icon4);

        //二值化
        Two.ToTwo();
        ImageIcon icon5 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\"+FileChoose.File_Name);
        textPane5.insertIcon(icon5);

        //闭运算,中值滤波
        Close.ToClose();
        ImageIcon icon6 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\Close\\"+FileChoose.File_Name);
        textPane6.insertIcon(icon6);

        //查找轮廓
        Find.ToFind();
        ImageIcon icon7 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\Close\\Find\\"+FileChoose.File_Name);
        textPane7.insertIcon(icon7);

        //剔出轮廓
        ImageIcon icon8 = new ImageIcon(FileChoose.File_Place+"\\Guass\\Grey\\Sobel\\Two\\Close\\Find\\Get\\"+FileChoose.File_Name);
        textPane8.insertIcon(icon8);

        //车牌综合处理
        Mat close_image = Imgcodecs.imread(FileChoose.File_Place + "\\Guass\\Grey\\Sobel\\Two\\Close\\Find\\Get\\" + FileChoose.File_Name);
        //灰度化
        cvtColor(close_image,close_image, Imgproc.COLOR_BGR2GRAY);

        //图像二值化
        Mat right = new Mat();
        threshold(close_image, right, 0, 255, THRESH_OTSU+THRESH_BINARY);
        Imgcodecs.imwrite(FileChoose.File_Place+"\\second\\1.png",right);
        ImageIcon icon9 = new ImageIcon(FileChoose.File_Place+"\\second\\1.png");
        textPane8.insertIcon(icon9);
        //高斯滤波
        Imgproc.GaussianBlur(right,right,new Size(3,3),0,0);
        Imgcodecs.imwrite(FileChoose.File_Place+"\\second\\2.png",right);
        ImageIcon icon10 = new ImageIcon(FileChoose.File_Place+"\\second\\2.png");
        textPane8.insertIcon(icon10);

        //字符分割
        Vector<ImageIcon> sort= GetPix.ToGetPix(right);
            textPane9.insertIcon(sort.get(0));
            textPane10.insertIcon(sort.get(1));
            textPane11.insertIcon(sort.get(2));
            textPane12.insertIcon(sort.get(3));
            textPane13.insertIcon(sort.get(4));
            textPane14.insertIcon(sort.get(5));
            textPane15.insertIcon(sort.get(6));

            //PixChar.ToChar();
    }

    private void initComponents(){
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        scrollPane3 = new JScrollPane();
        textPane1 = new JTextPane();
        panel2 = new JPanel();
        scrollPane4 = new JScrollPane();
        textPane2 = new JTextPane();
        panel3 = new JPanel();
        scrollPane5 = new JScrollPane();
        textPane3 = new JTextPane();
        panel4 = new JPanel();
        scrollPane1 = new JScrollPane();
        textPane4 = new JTextPane();
        panel5 = new JPanel();
        scrollPane2 = new JScrollPane();
        textPane5 = new JTextPane();
        panel6 = new JPanel();
        scrollPane6 = new JScrollPane();
        textPane6 = new JTextPane();
        panel7 = new JPanel();
        scrollPane7 = new JScrollPane();
        textPane7 = new JTextPane();
        panel8 = new JPanel();
        scrollPane8 = new JScrollPane();
        textPane8 = new JTextPane();
        scrollPane9 = new JScrollPane();
        textPane9 = new JTextPane();
        textPane10 = new JTextPane();
        textPane11 = new JTextPane();
        textPane12 = new JTextPane();
        textPane13 = new JTextPane();
        textPane14 = new JTextPane();
        textPane15 = new JTextPane();
        getpic = new JButton();
        label1 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("\u8f66\u724c\u8bc6\u522b\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(new GridLayout());

                //======== scrollPane3 ========
                {
                    scrollPane3.setViewportView(textPane1);
                }
                panel1.add(scrollPane3);
            }
            tabbedPane1.addTab("\u89e3\u6790\u8f66\u724c\u56fe\u50cf", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout());

                //======== scrollPane4 ========
                {
                    scrollPane4.setViewportView(textPane2);
                }
                panel2.add(scrollPane4);
            }
            tabbedPane1.addTab("\u9ad8\u65af\u6ee4\u6ce2", panel2);

            //======== panel3 ========
            {
                panel3.setLayout(new GridLayout());

                //======== scrollPane5 ========
                {
                    scrollPane5.setViewportView(textPane3);
                }
                panel3.add(scrollPane5);
            }
            tabbedPane1.addTab("\u7070\u5ea6\u5316", panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new GridLayout());

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textPane4);
                }
                panel4.add(scrollPane1);
            }
            tabbedPane1.addTab("Sobel", panel4);

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayout());

                //======== scrollPane2 ========
                {
                    scrollPane2.setViewportView(textPane5);
                }
                panel5.add(scrollPane2);
            }
            tabbedPane1.addTab("\u4e8c\u503c\u5316", panel5);

            //======== panel6 ========
            {
                panel6.setLayout(new GridLayout());

                //======== scrollPane6 ========
                {
                    scrollPane6.setViewportView(textPane6);
                }
                panel6.add(scrollPane6);
            }
            tabbedPane1.addTab("\u95ed\u8fd0\u7b97+\u4e2d\u503c\u6ee4\u6ce2", panel6);

            //======== panel7 ========
            {
                panel7.setLayout(new GridLayout());

                //======== scrollPane7 ========
                {
                    scrollPane7.setViewportView(textPane7);
                }
                panel7.add(scrollPane7);
            }
            tabbedPane1.addTab("\u67e5\u627e\u8f6e\u5ed3", panel7);

            //======== panel8 ========
            {
                panel8.setLayout(null);

                //======== scrollPane8 ========
                {
                    scrollPane8.setViewportView(textPane8);
                }
                panel8.add(scrollPane8);
                scrollPane8.setBounds(0, 0, 670, 195);

                //======== scrollPane9 ========
                {

                    //---- textPane9 ----
                    textPane9.setEditable(false);
                    scrollPane9.setViewportView(textPane9);
                }
                panel8.add(scrollPane9);
                scrollPane9.setBounds(5, 200, 63, 68);

                //---- textPane10 ----
                textPane10.setEditable(false);
                panel8.add(textPane10);
                textPane10.setBounds(105, 200, 63, 68);

                //---- textPane11 ----
                textPane11.setEditable(false);
                panel8.add(textPane11);
                textPane11.setBounds(210, 200, 63, 68);

                //---- textPane12 ----
                textPane12.setEditable(false);
                panel8.add(textPane12);
                textPane12.setBounds(315, 200, 63, 68);

                //---- textPane13 ----
                textPane13.setEditable(false);
                panel8.add(textPane13);
                textPane13.setBounds(420, 200, 63, 68);

                //---- textPane14 ----
                textPane14.setEditable(false);
                panel8.add(textPane14);
                textPane14.setBounds(515, 200, 63, 68);

                //---- textPane15 ----
                textPane15.setEditable(false);
                panel8.add(textPane15);
                textPane15.setBounds(605, 200, 63, 68);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel8.getComponentCount(); i++) {
                        Rectangle bounds = panel8.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel8.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel8.setMinimumSize(preferredSize);
                    panel8.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u63d0\u53d6\u8f66\u724c", panel8);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(5, 5, 675, 435);

        //---- getpic ----
        getpic.setText("\u4e0a\u4f20\u56fe\u50cf");
        getpic.addActionListener(e -> getpicActionPerformed(e));
        contentPane.add(getpic);
        getpic.setBounds(590, 450, 90, 28);

        //---- label1 ----
        label1.setText("\u4e0a\u4f20\u56fe\u50cf\u65f6\u8bf7\u6253\u5f00\u9879\u76ee\u76ee\u5f55\u4e0b\u7684carpic\u5b50\u76ee\u5f55\u9009\u62e9\u8f66\u724c\u56fe\u50cf");
        label1.setBackground(Color.white);
        label1.setForeground(Color.blue);
        contentPane.add(label1);
        label1.setBounds(5, 445, 320, 32);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        setSize(695, 525);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JScrollPane scrollPane3;
    private JTextPane textPane1;
    private JPanel panel2;
    private JScrollPane scrollPane4;
    private JTextPane textPane2;
    private JPanel panel3;
    private JScrollPane scrollPane5;
    private JTextPane textPane3;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTextPane textPane4;
    private JPanel panel5;
    private JScrollPane scrollPane2;
    private JTextPane textPane5;
    private JPanel panel6;
    private JScrollPane scrollPane6;
    private JTextPane textPane6;
    private JPanel panel7;
    private JScrollPane scrollPane7;
    private JTextPane textPane7;
    private JPanel panel8;
    private JScrollPane scrollPane8;
    private JTextPane textPane8;
    private JScrollPane scrollPane9;
    private JTextPane textPane9;
    private JTextPane textPane10;
    private JTextPane textPane11;
    private JTextPane textPane12;
    private JTextPane textPane13;
    private JTextPane textPane14;
    private JTextPane textPane15;
    private JButton getpic;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
