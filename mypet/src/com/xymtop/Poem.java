package com.xymtop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import com.xymtop.*;

public class Poem {
    JFrame frame;
    JLabel label;
    static Point mouse = new Point();
    Boolean ishide;
    Boolean alw;

    public Poem() {
        ishide = false;
        alw = true;
        // 获得当前屏幕的宽度，
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        String poem = GetPoem();
        frame = new JFrame("诗词");
        String html = "<html><body><h1>" + poem + "</body></html>";
        Rectangle r = new Rectangle(500, poem.length() / 20 * 100);

        label = new JLabel(html);
        frame.resize(r.width, r.height);
        label.setForeground(new Color(36, 187, 123));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 框体透明
        frame.setUndecorated(true); // 取消窗口标题栏
        frame.setBackground(new Color(0, 0, 0, 0));// 背景透明
        frame.add(label);
        // 设置位置并显示在最前端
        frame.setBounds(screenWidth - 5 * 20 * 5, 0, 500, 300);
        frame.setBounds(r);
        frame.setAlwaysOnTop(true);
        // 设置取消窗体任务栏图标
        frame.setType(JFrame.Type.UTILITY);
        frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
        frame.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("点击" + e.getButton());
                // TODO Auto-generated method stub
                if (e.getButton() == 3) {
                    String poem = GetPoem();
                    String html = "<html><body><h1>" + poem + "</body></html>";
                    Rectangle r = new Rectangle(500, poem.length() / 20 * 100);
                    label.setBounds(r);
                    label.setText(html);
                    frame.setSize(r.width, r.height);
                    frame.repaint();
                } else if (e.getButton() == 2) {
                    Random rand = new Random();
                    float r = rand.nextFloat();
                    float g = rand.nextFloat();
                    float b = rand.nextFloat();
                    label.setForeground(new Color(r, g, b));
                    frame.repaint();
                } else if (e.getButton() == 1) {
                    Util.Copy(label.getText());
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

        frame.addMouseMotionListener(new MouseMotionListener() {

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

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
        Opentray();
        frame.setVisible(true);
    }

    private String GetPoem() {
        String poemstr = HttpURLConnectionHelper.sendRequest("https://qqlykm.cn/api/yan/gc.php", "GET");
        System.out.println(poemstr);
        String[] str = poemstr.split("\"");
        String content = str[str.length - 4];
        String author = str[str.length - 8];
        String sub = str[str.length - 16];
        return content + "<br>---" + author + "《" + sub + "》";
    }

    // 系统托盘
    private void Opentray() {
        // 判断是否支持系统托盘
        if (SystemTray.isSupported()) {
            // 获取图片所在的URL,请把图片放在同一个包下
            // URL url = this.getClass().getResource("res/static/mylogo.png");
            // 实例化图像对象
            ImageIcon icon = new ImageIcon("res/static/mylogo.jpg");
            // 获得Image对象
            Image image = icon.getImage();
            // 创建托盘图标
            TrayIcon trayIcon = new TrayIcon(image);
            // 为托盘添加鼠标适配器
            trayIcon.addMouseListener(new MouseInputAdapter() {
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
            trayIcon.setToolTip("小野喵诗句,让你的桌面更优雅！");
            // 创建弹出菜单
            PopupMenu popupMenu = new PopupMenu();

            popupMenu.add(new MenuItem("隐藏或者显示"));
            popupMenu.add(new MenuItem("置顶窗口"));
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
                    } else if (cmd == "隐藏或者显示") {
                        if (ishide) {
                            frame.setVisible(true);
                            ishide = false;
                        } else {
                            frame.setVisible(false);
                            ishide = true;
                        }
                    } else if (cmd == "置顶窗口") {
                        frame.setAlwaysOnTop(!alw);
                        alw = !alw;
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
