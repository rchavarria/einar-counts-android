package es.rchavarria.einarcounts.core;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.media.MediaPlayer;

public class CachedVoicePlayer implements VoicePlayer {
	
	private Context context;
	private Map<Integer, MediaPlayer> cache;

	public CachedVoicePlayer(Context context) {
		this.context = context;
		cache = new HashMap<Integer, MediaPlayer>();
	}

	@Override
	public void play(Integer voiceResourceId) {
		MediaPlayer mp = cache.get(voiceResourceId);
		if(mp == null) {
			mp = MediaPlayer.create(context, voiceResourceId);
			cache.put(voiceResourceId, mp);
		}
		
		mp.start();
	}

}
