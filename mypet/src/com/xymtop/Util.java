package com.xymtop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Util {

    public static int convertFileEncoding(String srcFilePath, String srcCharset,
            String destFilePath, String destCharset, boolean isDeleteSrc) throws IOException {
        if (srcFilePath == null || srcFilePath.length() == 0)
            throw new IllegalArgumentException("srcFilePath is empty.");
        if (destFilePath == null || destFilePath.length() == 0)
            throw new IllegalArgumentException("destFilePath is empty.");
        if (srcFilePath.equalsIgnoreCase(destFilePath))
            throw new IllegalArgumentException("srcFilePath is the same as destFilePath");

        if (srcCharset == null || srcCharset.length() == 0)
            throw new IllegalArgumentException("srcCharset is empty.");
        if (destCharset == null || destCharset.length() == 0)
            throw new IllegalArgumentException("destCharset is empty.");

        if (srcCharset.equalsIgnoreCase(destCharset)) // 编码相同，无需转换
            return 0;

        File srcFile = new File(srcFilePath);

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;

        try {
            fis = new FileInputStream(srcFile);
            isr = new InputStreamReader(fis, srcCharset);

            // BufferedReader中defaultCharBufferSize = 8192.
            // 即：8192 × 2 byte = 16k
            // 若是utf-8,中文占3个字节，16K / 3 = 5461，即只要每行中文字符数 < 5461,读取的行数就是准确的，
            // 否则，可能会截断一行，多写入'\n',但这种情况一般不存在。
            // 如果源文件中最后一行没有换行符，转码后的文件最后会多写入一个换行符
            br = new BufferedReader(isr);

            // 以UTF-8格式写入文件,file.getAbsolutePath()即该文件的绝对路径,false代表不追加直接覆盖,true代表追加文件
            fos = new FileOutputStream(destFilePath, false);
            osw = new OutputStreamWriter(fos, destCharset);

            String str = null;

            // 创建StringBuffer字符串缓存区
            StringBuffer sb = new StringBuffer();
            int lines = 0;

            // 通过readLine()方法遍历读取文件
            while ((str = br.readLine()) != null) {
                // 使用readLine()方法无法进行换行,需要手动在原本输出的字符串后面加"\n"或"\r"
                sb.append(str).append('\n');
                osw.write(sb.toString());
                osw.flush();
                lines++;
            }

            if (isDeleteSrc) {
                if (srcFile.delete())
                    System.out.println(srcFile.getAbsolutePath() + " file is already deleted.");
                else
                    System.out.println(srcFile.getAbsolutePath() + " file delete fail.");
            }

            // System.out.println(lines);
            return lines;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            throw e;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            throw e;
        } catch (IOException e) {

            throw e;
        } finally {
            // 与同一个文件关联的所有输出流(输入流)，只需关闭一个即可
            if (null != fis)
                try {
                    fis.close();
                    fis = null;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            if (null != fos)
                try {
                    fos.close();
                    fos = null;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    public static void OpenUrl(String url) {
        try {

            java.net.URI uri = java.net.URI.create(url);

            // 获取当前系统桌面扩展

            java.awt.Desktop dp = java.awt.Desktop.getDesktop();

            // 判断系统桌面是否支持要执行的功能

            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                // File file = new File("D:\\aa.txt");
                // dp.edit(file);// 编辑文件

                dp.browse(uri);// 获取系统默认浏览器打开链接
                // dp.open(file);// 用默认方式打开文件
                // dp.print(file);// 用打印机打印文件
            }

        } catch (java.lang.NullPointerException e) {

            // 此为uri为空时抛出异常

            e.printStackTrace();

        } catch (java.io.IOException e) {

            // 此为无法获取系统默认浏览器

            e.printStackTrace();

        }

    }

    // 延迟一段时间播放音频
    public static void SleepExecSpeak(String Msg, int min) {
        new Thread() {
            public void run() {
                try {
                    sleep(min);
                    Music.PlayMusicPy(System.getProperty("user.dir") + "\\res\\msg\\" + Msg + ".mp3");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
