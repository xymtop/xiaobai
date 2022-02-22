package com.xymtop;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

//待办事项
public class ToDo extends JFrame {
    public ToDo() throws IOException {
        // this.setVisible(true);
        System.out.println(MyFile.ReadFile("res/todo/2.txt"));
        MyFile.FileWrite("res/todo/2.txt", "哈哈哈");
    }
}
