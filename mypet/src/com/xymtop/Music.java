package com.xymtop;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    public static void PlayWav(String url) {
        new Thread() {

            public void run() {
                AudioInputStream as;
                try {
                    as = AudioSystem.getAudioInputStream(new File(url));
                    AudioFormat format = as.getFormat();
                    SourceDataLine sdl = null;
                    DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                    sdl = (SourceDataLine) AudioSystem.getLine(info);
                    sdl.open(format);
                    sdl.start();
                    int nBytesRead = 0;
                    byte[] abData = new byte[512];
                    while (nBytesRead != -1) {
                        nBytesRead = as.read(abData, 0, abData.length);
                        if (nBytesRead >= 0)
                            sdl.write(abData, 0, nBytesRead);
                    }
                    // 关闭SourceDataLine
                    sdl.drain();
                    sdl.close();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();

    }

    // 调用python播放音频
    public static void PlayMusicPy(String url) {
        try {
            String cmd = MyFile.GetCmdUrl(System.getProperty("user.dir") + "\\res\\pymusic\\music.exe  " + url);
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 播放声音消息
    public static void PlayMsg(String msg) throws NoSuchAlgorithmException {
        try {
            MyHttp.DownLoadMsg(msg);
            Music.PlayMusicSleep(msg, 3 * 1000);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 延迟播放声音
    public static void PlayMusicSleep(String Msg, int min) {
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

    // 播放云端声音消息
    public static void PlayWavRemote(String url) throws IOException {
        long id = new Date().getTime();
        MyHttp.downLoadFromUrl(url, String.valueOf(id) + ".mp3", "res/msg/");
        Music.PlayMusicSleep(String.valueOf(id), 5 * 1000);
    }

}
