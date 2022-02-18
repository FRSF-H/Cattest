package com.second;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileChoose {
    public static String File_Path = null;
    public static String File_Place = null;
    public static String File_Name = null;
    public static File getFile(Container jf) {
        File file = null;
        JFileChooser jfc = new JFileChooser();
        int i = jfc.showOpenDialog(jf);
        if (i == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
        } else {
            JOptionPane.showMessageDialog(jf, "未成功选择图片", "文件选择提示", JOptionPane.WARNING_MESSAGE);
        }
        File_Path = file.getAbsolutePath();
        File_Place = file.getParent();
        File_Name = file.getName();
        //System.out.println(File_Name);
        return file;
    }
}
