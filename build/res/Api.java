package com.xymtop.res;

import com.xymtop.HttpURLConnectionHelper;

public class Api {
    // 获取一句毒鸡汤
    public static String GetText() {
        String text = HttpURLConnectionHelper.sendRequest("https://api.muxiaoguo.cn/api/dujitang", "POST");
        String[] str = text.split("\"");
        if (str[str.length - 6].length() == 0) {
            text = "我爱你我的宝";
        } else {
            text = str[str.length - 6];
        }
        return text;
    }

}
