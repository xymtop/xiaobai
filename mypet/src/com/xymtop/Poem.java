package com.xymtop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Poem {
    JFrame frame;
    JLabel label;
    static Point mouse = new Point();

    public Poem() {
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
        label.setForeground(new Color(8, 46, 55));
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

}
