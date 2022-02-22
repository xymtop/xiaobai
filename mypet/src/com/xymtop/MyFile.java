package com.xymtop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.swing.filechooser.FileSystemView;

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

    // 返回路径下所有文件
    public static String[] GetPathFile(String path) throws FileNotFoundException {
        File file = new File(path);
        String[] filelist = file.list();
        String[] Res = new String[filelist.length];
        int Num = 0;
        for (int i = 0; i < filelist.length; i++) {
            File readfile = new File(path + "\\" + filelist[i]);
            if (!readfile.isDirectory()) {
                Res[Num] = readfile.getAbsolutePath();
                Num++;
            }
        }
        return Res;
    }

    // 返回桌面下随机路径
    public static String GetDesktopRandUrl() {
        FileSystemView view = FileSystemView.getFileSystemView();
        File file = view.getHomeDirectory();
        String Res[] = null;
        String url = null;
        int index = 0;
        try {
            Res = MyFile.GetPathFile(file.getAbsolutePath());
            index = (int) (Math.random() * (Res.length - 1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (Res[index] == null) {
            url = MyFile.GetDesktopRandUrl();
        } else {
            url = Res[index];
        }
        return url;
    }

    // 返回目录下文件的数量
    public static int GetNum(String path) {
        File file = new File(path);
        int num = file.list().length;
        return num;
    }

    // 移动文件到文件夹
    public static void moveFileToRecycle(String fromPath) {
        String toPath = "recycle";
        System.out.println("移动文件：从路径 " + fromPath + " 移动到路径 " + toPath);
        File file = new File(fromPath);
        if (file.isDirectory()) {
            for (String item : file.list()) {
                moveFileToRecycle(new File(item).getAbsolutePath());
            }
        } else {
            File toFile = new File(toPath + "\\" + file.getName());
            if (toFile.exists()) {
                File toFile2 = new File(toPath + "\\" + String.valueOf(new Date().getTime()) + file.getName());
                file.renameTo(toFile2);
            } else {
                file.renameTo(toFile);
                System.out.println("移动文件成功");
            }
        }
    }

}
