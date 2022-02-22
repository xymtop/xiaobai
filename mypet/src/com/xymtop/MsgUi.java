
package com.xymtop;

//聊天窗口
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.swing.*;

public class MsgUi extends JFrame {

    JTextArea wby; // 文本域
    JPanel mb; // 面板
    JComboBox xlk; // 下拉框
    JButton an; // 按钮
    JTextField wbk; // 文本框
    JScrollPane gd; // 滚动

    public MsgUi() {
        // 添加
        wby = new JTextArea("系统: 开始聊天吧\n");

        mb = new JPanel();
        String[] lt = { "小白", "开发者" };
        xlk = new JComboBox(lt);
        an = new JButton("发送");
        wbk = new JTextField(20);
        gd = new JScrollPane(wby);

        // 添加到面板
        mb.add(xlk);
        mb.add(wbk);
        mb.add(an);
        this.add(gd);
        this.add(mb, BorderLayout.SOUTH);

        an.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String MyMsg = wbk.getText();
                int people = xlk.getSelectedIndex();
                AddMsg("你: " + wbk.getText());
                if (people == 0) {
                    // 和小白聊天
                    try {
                        String n = new String(MyMsg.getBytes("UTF-8"), "GBK");
                        String data = HttpURLConnectionHelper.sendRequest(
                                "http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + n, "POST");
                        System.out.println(data);
                        String[] BaiMsg = data.split("\"");
                        String Msg = BaiMsg[BaiMsg.length - 2];
                        try {
                            Music.PlayMsg(Msg);
                        } catch (NoSuchAlgorithmException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        AddMsg("小白: " + Msg);

                    } catch (UnsupportedEncodingException e2) {
                        // TODO Auto-generated catch block
                        e2.printStackTrace();
                    }

                } else {
                    // 反馈
                    try {
                        String n = new String(MyMsg.getBytes("UTF-8"), "GBK");
                        String n2 = new String("小白软件反馈".getBytes("UTF-8"), "GBK");
                        String url = "https://api.dzzui.com/api/mail?Host=smtp.qq.com&Username=polarislovetop@qq.com&Password=pabqwbqicljmicfb&Port=465&SMTPSecure=ssl&addAddress=2283761246@qq.com&title="
                                + n2 + "&text="
                                + n;
                        HttpURLConnectionHelper.sendRequest(url, "POST");
                        try {
                            Music.PlayMsg("反馈成功，感谢你的支持");
                        } catch (NoSuchAlgorithmException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        AddMsg("系统: 反馈成功！");
                    } catch (UnsupportedEncodingException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                }
                wbk.setText("");
            }

        });
        // 设置窗口标题
        this.setTitle("聊天窗口");
        // 设置窗口的宽高
        this.setSize(500, 350);
        // 添加标题栏图片
        this.setIconImage((new ImageIcon("res/static/mylogo.jpg")).getImage());
        // 设置窗口出现对于屏幕的位置
        this.setLocation(100, 100);
        // 禁止拉大拉小
        this.setResizable(false);
        // 设置取消窗体任务栏图标
        this.setType(JFrame.Type.UTILITY);
        // 关闭窗口
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // 输出窗口
        this.setVisible(false);
    }

    private void AddMsg(String msg) {

        wby.append(msg + "\n");
    }

    // 设置窗口位置
    public void SetLoc(int x, int y) {
        this.setLocation(x, y);
    }

    // 设置窗口是否显示
    public void SetView(Boolean flag) {
        if (flag) {
            Music.PlayMusicPy(System.getProperty("user.dir") + "\\res\\msg\\lib\\chat.mp3");
        }
        this.setVisible(flag);
    }

}