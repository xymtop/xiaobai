package com.xymtop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseAdapter;

public class Pet {
    JFrame frame;
    JLabel pet;
    JPopupMenu popup;
    MsgUi msg;
    static Point mouse = new Point();
    static int WinH = 200;
    static int WinW = 200;
    static int SleepTime = 10;
    static String ThePet = "other1";
    // falg
    boolean flag = true;
    // 人物是否活动
    boolean active = false;
    // 消息窗口是否打开
    boolean msgui = true;
    // 窗口是否隐藏
    boolean ishide = false;

    public Pet() {
        frame = new JFrame("小白");

        msg = new MsgUi();
        popup = new JPopupMenu();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 框体透明
        frame.setUndecorated(true); // 取消窗口标题栏
        frame.setBackground(new Color(0, 0, 0, 0));// 背景透明
        // 设置位置并显示在最前端
        frame.setBounds(MyWindow.GetWindowW() - Pet.WinW, MyWindow.GetWindowH() - Pet.WinH - 100, Pet.WinW, Pet.WinH);
        frame.setAlwaysOnTop(true);
        // 设置取消窗体任务栏图标
        frame.setType(JFrame.Type.UTILITY);

        pet = new JLabel(new ImageIcon("1.png"));

        frame.add(pet);

        // Walking();
        ChangeImgThread();
        pet.setBounds(0, 0, 200, 200);

        pet.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {

                    // 鼠标左键单击
                    if (e.getButton() == 1) {
                        Walking();
                    }

                    // 按鼠标中间
                    if (e.getButton() == 2) {
                        WalkDrop();
                    }

                    // 右键
                    if (e.getButton() == 3) {
                        JPopupMenu popup = new JPopupMenu();
                        JMenuItem wall = new JMenuItem("更换专属壁纸");
                        JMenuItem chat = new JMenuItem("和我聊天");
                        JMenuItem help = new JMenuItem("帮助");
                        JMenuItem about = new JMenuItem("关于");
                        JMenuItem hide = new JMenuItem("隐藏");
                        JMenuItem exit = new JMenuItem("退出");

                        // 菜单点击事件
                        chat.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                // reg add "hkcu\control panel\desktop" /v wallpaper /d "新壁纸地址(绝对地址）" /f
                                if (msgui) {
                                    msg.SetView(true);
                                } else {
                                    msg = new MsgUi();
                                }
                            }

                        });
                        wall.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                // reg add "hkcu\control panel\desktop" /v wallpaper /d "新壁纸地址(绝对地址）" /f
                                WallPaper.ChangeOne();
                            }

                        });

                        help.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                Util.OpenUrl("https://xymtop.gitee.io/xiaobai/#/");
                            }

                        });

                        about.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                Util.OpenUrl("https://gitee.com/xymtop/xiaobai");
                            }

                        });

                        hide.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                frame.hide();
                                ishide = true;

                            }

                        });

                        exit.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // TODO Auto-generated method stub
                                msg.dispose();
                                System.exit(0);

                            }

                        });
                        popup.add(chat);
                        popup.add(wall);
                        popup.add(help);
                        popup.add(about);
                        popup.add(hide);
                        popup.add(exit);

                        popup.show(e.getComponent(), e.getX(), e.getY());
                    }

                } else if (e.getClickCount() == 2) {
                    WalkDrop();
                } else {
                    Grabed();
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                mouse.x = e.getX();
                mouse.y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });

        // 人物鼠标事件
        pet.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
                new Thread() {
                    public void run() {
                        if (!active) {
                            if (!msgui) {
                                new MsgUi();
                                msgui = true;
                            }
                        } else {
                            System.out.println(e.getX() + " " + e.getY());
                        }

                    }
                }.start();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO Auto-generated method stub
                new Thread() {
                    public void run() {
                        Point p = frame.getLocation();
                        int x = e.getX() + p.x - mouse.x;
                        int y = e.getY() + p.y - mouse.y;
                        frame.setLocation(x, y);
                    }
                }.start();

            }

        });

        // 打开托盘
        Opentray();
        frame.setVisible(true);

    }

    // 改变人物的动作
    private void ChangeImgThread() {
        new Thread() {
            public void run() {
                while (true) {

                    int i = (int) (Math.random() * 5);
                    if (i == 0) {
                        Default();
                    } else if (i == 1) {
                        Walking();
                    } else if (i == 2) {
                        ClickOne();
                    } else if (i == 3) {
                        WalkDrop();
                    } else if (i == 4) {
                        Grabed();
                    } else {
                        Default();
                    }

                    active = false;
                }

            }
        }.start();
    }

    // 更新渲染图片
    private void ChangeImg(String img) {
        pet.setIcon(new ImageIcon(img));
        frame.validate();
        frame.repaint();
    }

    // 向前行走
    private void Walking() {

        for (int i = 0; i <= 60; i++) {
            ChangeImg("res/walking/skeleton-walking" + String.valueOf(i) + ".png");

            if (frame.getLocation().x + 5 >= MyWindow.GetWindowW()) {
                frame.setBounds(frame.getLocation().x + 5, frame.getLocation().y, Pet.WinW, Pet.WinH);
                frame.setBounds(0 + 5, frame.getLocation().y, Pet.WinW, Pet.WinH);
            } else {
                frame.setBounds(frame.getLocation().x + 5, frame.getLocation().y, Pet.WinW, Pet.WinH);
            }
            try {
                Thread.sleep(Pet.SleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // 向上跳
    private void WalkDrop() {

        for (int i = 0; i <= 60; i++) {
            ChangeImg("res/grabed/skeleton-grabed" + String.valueOf(i) + ".png");
            // frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW,
            // Pet.WinH);
            if (frame.getLocation().y - 5 <= 0) {
                frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW, Pet.WinH);
                frame.setBounds(frame.getLocation().x, MyWindow.GetWindowH() - 5, Pet.WinW, Pet.WinH);
            } else {
                frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW, Pet.WinH);
            }
            try {
                Thread.sleep(Pet.SleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 静止状态
    private void ClickOne() {

        for (int i = 0; i <= 60; i++) {
            ChangeImg("res/clickOne/skeleton-smile" + String.valueOf(i) + ".png");
            // frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW,
            // Pet.WinH);
            try {
                Thread.sleep(Pet.SleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // 默认状态
    private void Default() {

        for (int i = 0; i <= 60; i++) {
            ChangeImg("res/default/skeleton-standing" + String.valueOf(i) + ".png");
            // frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW,
            // Pet.WinH);
            try {
                Thread.sleep(Pet.SleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // 不知道叫啥状态
    private void Grabed() {

        for (int i = 0; i <= 60; i++) {
            ChangeImg("res/grabed/skeleton-grabed" + String.valueOf(i) + ".png");
            // frame.setBounds(frame.getLocation().x, frame.getLocation().y - 5, Pet.WinW,
            // Pet.WinH);
            try {
                Thread.sleep(Pet.SleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 系统托盘
    private void Opentray() {
        // 判断是否支持系统托盘
        if (SystemTray.isSupported()) {
            // 获取图片所在的URL,请把图片放在同一个包下
            // URL url = this.getClass().getResource("res/static/mylogo.png");
            // 实例化图像对象
            ImageIcon icon = new ImageIcon("res/static/pet.jpg");
            // 获得Image对象
            Image image = icon.getImage();
            // 创建托盘图标
            TrayIcon trayIcon = new TrayIcon(image);
            // 为托盘添加鼠标适配器
            trayIcon.addMouseListener(new MouseAdapter() {
                // 鼠标事件
                public void mouseClicked(MouseEvent e) {
                    // 判断是否双击了鼠标
                    if (e.getClickCount() == 2) {
                        if (ishide) {
                            frame.setVisible(true);
                        } else {
                            frame.setLocation(0, 0);
                        }
                    }
                }
            });

            // 添加工具提示文本
            trayIcon.setToolTip("小白\r\n状态：正在运行\r\n");
            // 创建弹出菜单
            PopupMenu popupMenu = new PopupMenu();
            // popupMenu.add(new MenuItem("帮助"));
            // popupMenu.add(new MenuItem("关于"));
            popupMenu.add(new MenuItem("退出"));

            // 监听菜单点击事件
            popupMenu.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    String cmd = e.getActionCommand();
                    if (cmd == "退出") {
                        System.exit(0);
                    }
                }

            });

            popupMenu.addSeparator();

            // 为托盘图标加弹出菜弹
            trayIcon.setPopupMenu(popupMenu);
            // 获得系统托盘对象
            SystemTray systemTray = SystemTray.getSystemTray();
            try {
                // 为系统托盘加托盘图标
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "不支持桌面托盘");
        }
    }

}
