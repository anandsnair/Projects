package com.informatica.adapter;

/**
 * This comes as a bridge between 2 incompatible interfaces.
 * @author anair
 *
 */
public class App {

	public static void main(String[] args) {
		MediaPlayer player = new AudioPlayer();
		player.play(AudioType.VLC, "abc.vlc");
		player.play(AudioType.MP3, "ts");
	}
}
