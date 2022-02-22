package com.xymtop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MyFile {

    // 返回cmd可用的命令行url
    public static String GetCmdUrl(String url) {
        String cmdurl = "";
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i) == '\\') {
                cmdurl = cmdurl + "\\\\";
            } else {
                cmdurl = cmdurl + url.charAt(i);
            }
        }
        System.out.println(cmdurl);
        return cmdurl;
    }

    // 写入数据到文件
    public static void FileWrite(String path, String content) throws IOException {
        String n = new String(content.getBytes("UTF-8"), "GBK");
        try (FileWriter fileWriter = new FileWriter(path)) {
            try {
                fileWriter.append(n);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读取文件内容
    public static String ReadFile(String filepath) throws FileNotFoundException {
        String encoding = "UTF-8";
        File file = new File(filepath);
        Long filelength = file.length();
        byte[] filecontent = new byte[filelength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(filecontent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(filecontent, encoding);
        } catch (UnsupportedEncodingException e) {
            System.err.println("The OS does not support " + encoding);
            e.printStackTrace();
            return null;
        }

    }

}
