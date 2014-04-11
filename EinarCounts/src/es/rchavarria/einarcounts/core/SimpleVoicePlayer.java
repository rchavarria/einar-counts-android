package es.rchavarria.einarcounts.core;

import android.content.Context;
import android.media.MediaPlayer;

public class SimpleVoicePlayer implements VoicePlayer {
	
	private Context context;

	public SimpleVoicePlayer(Context context) {
		this.context = context;
	}

	@Override
	public void play(Integer voiceResourceId) {
		MediaPlayer.create(context, voiceResourceId).start();
	}

}
