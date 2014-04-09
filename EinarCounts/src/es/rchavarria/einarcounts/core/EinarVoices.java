package es.rchavarria.einarcounts.core;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.einarcounts.R;

public class EinarVoices {

	private VoicePlayer player;
	private List<Integer> longVoices;

	public EinarVoices(VoicePlayer player) {
		this.player = player;
		
		longVoices = new ArrayList<Integer>(10);
		longVoices.add(R.raw.one_long);
		longVoices.add(R.raw.two_long);
		longVoices.add(R.raw.three_long);
		longVoices.add(R.raw.four_long);
		longVoices.add(R.raw.five_long);
		longVoices.add(R.raw.six_long);
		longVoices.add(R.raw.seven_long);
		longVoices.add(R.raw.eight_long);
		longVoices.add(R.raw.nine_long);
		longVoices.add(R.raw.ten_long);
	}

	public void play(String voiceIdentifier) {
		if(voiceIdentifier == null || voiceIdentifier.length() == 0) {
			throw new IllegalArgumentException("Can not play voice with identifier: " + voiceIdentifier);
		}
		
		int voiceResource = getVoiceResource(voiceIdentifier);
		if(voiceResource < 0) {
			voiceResource = R.raw.error;
		}
		
		player.play(voiceResource);
	}

	private int getVoiceResource(String voiceIdentifier) {
		Integer id = null;
		try {
			id = Integer.parseInt(voiceIdentifier);
			// list starts at 0 while count starts at 1
			id--;
			
			return longVoices.get(id);

		} catch(Exception e) {}
		
		return -1;
	}
}
