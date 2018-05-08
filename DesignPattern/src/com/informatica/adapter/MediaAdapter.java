package com.informatica.adapter;

public class MediaAdapter implements MediaPlayer {
	AdvancedMediaPlayer advancedPlayer;
	
	@Override
	public void play(AudioType audioType, String filename) {
		if(audioType.equals(AudioType.VLC)) {
			advancedPlayer = new VLCPlayer();
			advancedPlayer.playVLC(filename);
		} else if(audioType.equals(AudioType.MP4)) {
			advancedPlayer = new MP4Player();
			advancedPlayer.playMP4(filename);
		}

	}

}
