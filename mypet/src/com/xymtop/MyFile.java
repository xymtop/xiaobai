package com.xymtop;

public class MyFile {

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
}
