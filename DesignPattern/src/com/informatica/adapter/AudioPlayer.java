package com.informatica.adapter;

public class AudioPlayer implements MediaPlayer {
	MediaAdapter adapter;
	@Override
	public void play(AudioType audioType, String filename) {
		if(audioType.equals(AudioType.MP3)) {
			System.out.println("Play MP3");
		} else {
			adapter = new MediaAdapter();
			adapter.play(audioType, filename);
		}
	}

}
