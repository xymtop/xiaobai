package com.xymtop;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.xymutil.MyWindow;

public class MsgUi extends JFrame {
    JFrame frame;
    JLabel pet;

    public MsgUi() {
        frame = new JFrame("消息窗口");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 框体透明
        // frame.setUndecorated(true); // 取消窗口标题栏
        // frame.setBackground(new Color(0, 0, 0, 0));// 背景透明
        // 设置位置并显示在最前端
        frame.setBounds(MyWindow.GetWindowW(), 100, 200, 200);
        frame.setAlwaysOnTop(true);
        // 设置取消窗体任务栏图标
        frame.setType(JFrame.Type.UTILITY);

        // 设置背景图片
        // 设置背景
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象

        ImageIcon icon = new ImageIcon("res/static/msg.jpg"); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        frame.getContentPane().add(lblBackground); // 将组件添加到面板中

        frame.setVisible(true);
    }

    // 设置消息
    public void SetMsg(int x, int y, String mymsg) {

    }

}
