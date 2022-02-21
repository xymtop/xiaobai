package com.xymtop;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Music.PlayMusicPy(System.getProperty("user.dir") + "\\res\\msg\\sayhi.mp3");
		new Pet();
	}

}
