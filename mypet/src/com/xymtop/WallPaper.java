package com.xymtop;

import java.io.IOException;

public class WallPaper {
    public static void ChangeOne() {
        // 先随机产生一个下标再获取元素

        int index = (int) (Math.random() * 20);

        String url = System.getProperty("user.dir") + "\\res\\wall\\wall (" + String.valueOf(index) + ").jpg";
        String cmd = "reg add " + "\"hkcu\\control panel\\desktop\"" + " /v wallpaper /d \""
                + url
                + "\"" + " /f";
        try {
            Command.RunCmd(cmd);
            Command.RunCmd("RunDll32.exe USER32.DLL,UpdatePerUserSystemParameters");
            Command.RunCmd("RunDll32.exe USER32.DLL,UpdatePerUserSystemParameters");
            Command.RunCmd("RunDll32.exe USER32.DLL,UpdatePerUserSystemParameters");
        } catch (IOException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }
}
