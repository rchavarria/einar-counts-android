package es.rchavarria.einarcounts.core;

import android.content.Context;
import android.media.MediaPlayer;
import es.rchavarria.einarcounts.R;

public class EinarVoices implements Voices {

	private Context context;

	public EinarVoices(Context context) {
		this.context = context;
	}

	@Override
	public void play(String voiceIdentifier) {
		if(voiceIdentifier == null || voiceIdentifier.length() == 0) {
			throw new IllegalArgumentException("Can not play voice with identifier: " + voiceIdentifier);
		}
		
		int voiceResource = getVoiceResource(voiceIdentifier);
		MediaPlayer player = MediaPlayer.create(this.context, voiceResource);
		player.start();
	}

	private int getVoiceResource(String voiceIdentifier) {
		return R.raw.one_long;
	}
}
