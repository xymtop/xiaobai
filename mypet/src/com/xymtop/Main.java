package com.xymtop;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Music.PlayMusicPy(System.getProperty("user.dir") +
				"\\res\\msg\\lib\\sayhi.mp3");
		Util.SleepExecSpeak("lib\\start", 3 * 1000);
		new Pet("主程序");

	}
}
