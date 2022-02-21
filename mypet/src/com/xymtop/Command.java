package com.xymtop;

import java.io.IOException;

public class Command {
    // 运行cmd
    public static void RunCmd(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }

    // 运行多个cmd
    public static void RunCmds(String[] cmds) throws IOException {
        Runtime.getRuntime().exec(cmds);
    }

    // 刷新注册表
    public static void Flush() throws IOException {
        Runtime.getRuntime().exec("RunDll32.exe USER32.DLL,UpdatePerUserSystemParameters");
    }

}
