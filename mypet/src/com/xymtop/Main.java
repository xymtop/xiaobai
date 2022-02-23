package com.xymtop;

import java.security.NoSuchAlgorithmException;;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Music.PlayMusicPy(System.getProperty("user.dir") +
				"\\res\\msg\\lib\\sayhi.mp3");
		Util.SleepExecSpeak("lib\\start", 3 * 1000);
		new Pet("主程序");
	}
}
