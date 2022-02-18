package com.frsf;

import com.second.judge;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.plaf.*;
/*
 * Created by JFormDesigner on Tue Sep 21 17:38:18 CST 2021
 */



/**
 * @author FRSF
 * 项目启动日期         2021年9月24日
 */
public class login extends JFrame {
    public login() {
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        String user = IDC_USERNAME_SRK.getText();
        String pass = passwordField1.getText();
        Connection connection = mysql.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from userinfo");
            int flag = 0;
            while (resultSet.next()){
                if(resultSet.getString(1).equals(user)&&resultSet.getString(2).equals(pass)) {
                    JOptionPane.showMessageDialog(this,"登录成功","登录提示",JOptionPane.INFORMATION_MESSAGE);
                    new judge();
                    this.dispose();
                    flag = 1;
                }
            }
            if(flag == 0){
                JOptionPane.showMessageDialog(this,"登录失败","登录提示",JOptionPane.WARNING_MESSAGE);            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            mysql.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        this.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        IDC_USERNAME_SRK = new JTextField();
        passwordField1 = new JPasswordField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u8f66\u724c\u8bc6\u522b\u767b\u5f55\u7a0b\u5e8f");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setForeground(new Color(76, 80, 82));
            dialogPane.setBackground(new Color(76, 80, 82));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setBackground(new Color(51, 51, 51));
                contentPanel.setLayout(null);

                //======== panel3 ========
                {
                    panel3.setForeground(Color.gray);
                    panel3.setBackground(new Color(51, 51, 51));
                    panel3.setLayout(null);

                    //---- label2 ----
                    label2.setText("\u5bc6\u7801\uff1a");
                    label2.setHorizontalTextPosition(SwingConstants.LEFT);
                    label2.setHorizontalAlignment(SwingConstants.CENTER);
                    label2.setForeground(Color.white);
                    panel3.add(label2);
                    label2.setBounds(10, 125, 60, 35);

                    //---- label3 ----
                    label3.setText("\u8d26\u53f7\uff1a");
                    label3.setHorizontalTextPosition(SwingConstants.LEFT);
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    label3.setForeground(Color.white);
                    panel3.add(label3);
                    label3.setBounds(10, 45, 60, 35);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                contentPanel.add(panel3);
                panel3.setBounds(10, 0, panel3.getPreferredSize().width, 202);

                //---- IDC_USERNAME_SRK ----
                IDC_USERNAME_SRK.setBackground(Color.gray);
                contentPanel.add(IDC_USERNAME_SRK);
                IDC_USERNAME_SRK.setBounds(100, 40, 235, 40);

                //---- passwordField1 ----
                passwordField1.setBackground(Color.gray);
                contentPanel.add(passwordField1);
                passwordField1.setBounds(100, 120, 235, 40);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setBackground(new Color(60, 63, 65));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u767b\u5f55");
                okButton.setBackground(new Color(60, 63, 65));
                okButton.setForeground(Color.white);
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u9000\u51fa");
                cancelButton.setBackground(new Color(60, 63, 65));
                cancelButton.setForeground(Color.white);
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(395, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;
    private JTextField IDC_USERNAME_SRK;
    private JPasswordField passwordField1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
