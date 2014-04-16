package es.rchavarria.einarcounts.core;

import java.util.HashMap;
import java.util.Map;

import es.rchavarria.einarcounts.R;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class PoolVoicePlayer implements VoicePlayer {
	
	private Context context;
	private Map<Integer, Integer> sounds;
	private SoundPool pool;

	public PoolVoicePlayer(Context context) {
		this.context = context;
		sounds = new HashMap<Integer, Integer>();
		pool = new SoundPool(31, AudioManager.STREAM_MUSIC, 0);
		
		loadPool();
	}
	
	private void loadPool() {
		sounds.put(R.raw.error, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.one_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.two_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.three_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.four_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.five_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.six_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.seven_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.eight_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.nine_long, pool.load(context, R.raw.error, 1));
		sounds.put(R.raw.ten_long, pool.load(context, R.raw.error, 1));
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
