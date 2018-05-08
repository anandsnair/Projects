package com.informatica.adapter;

public class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String filename) {
		System.out.println("Playing VLC "+filename);
	}

	@Override
	public void playMP4(String filename) {
		// TODO Auto-generated method stub

	}

}
