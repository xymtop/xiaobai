package com.xymtop;

import java.awt.Dimension;
import java.awt.Toolkit;

public class MyWindow {

    public static int GetWindowW() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = dim.width;
        return w;
    }

    public static int GetWindowH() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int h = dim.height;
        return h;
    }
}
