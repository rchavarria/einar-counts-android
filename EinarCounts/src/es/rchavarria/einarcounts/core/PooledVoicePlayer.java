package es.rchavarria.einarcounts.core;

import java.util.HashMap;
import java.util.Map;

import es.rchavarria.einarcounts.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class PooledVoicePlayer implements VoicePlayer {
	
	private Context context;
	private Map<Integer, Integer> sounds;
	private SoundPool pool;

	public PooledVoicePlayer(Context context) {
		this.context = context;
		sounds = new HashMap<Integer, Integer>();
		pool = new SoundPool(31, AudioManager.STREAM_MUSIC, 0);
		
		loadPool();
	}
	
	private void loadPool() {
		loadSound(R.raw.error);
		
		loadSound(R.raw.one_long);
		loadSound(R.raw.two_long);
		loadSound(R.raw.three_long);
		loadSound(R.raw.four_long);
		loadSound(R.raw.five_long);
		loadSound(R.raw.six_long);
		loadSound(R.raw.seven_long);
		loadSound(R.raw.eight_long);
		loadSound(R.raw.nine_long);
		loadSound(R.raw.ten_long);
		
		loadSound(R.raw.one_clear);
		loadSound(R.raw.two_clear);
		loadSound(R.raw.three_clear);
		loadSound(R.raw.four_clear);
		loadSound(R.raw.five_clear);
		loadSound(R.raw.six_clear);
		loadSound(R.raw.seven_clear);
		loadSound(R.raw.eight_clear);
		loadSound(R.raw.nine_clear);
		loadSound(R.raw.ten_clear);

		loadSound(R.raw.one_short);
		loadSound(R.raw.two_short);
		loadSound(R.raw.three_short);
		loadSound(R.raw.four_short);
		loadSound(R.raw.five_short);
		loadSound(R.raw.six_short);
		loadSound(R.raw.seven_short);
		loadSound(R.raw.eight_short);
		loadSound(R.raw.nine_short);
		loadSound(R.raw.ten_short);
	}
	
	private void loadSound(Integer soundResourceId) {
		sounds.put(soundResourceId, pool.load(context, soundResourceId, 1));
	}

	@Override
	public void play(Integer voiceResourceId) {
		float volume = computeVolume();
		pool.play(sounds.get(voiceResourceId), volume, volume, 1, 0, 1f);
	}

	private float computeVolume() {
		AudioManager mngr = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		float current = (float) mngr.getStreamVolume(AudioManager.STREAM_MUSIC);
		float max = (float) mngr.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		
		return current / max;
	}

}
