package es.rchavarria.einarcounts.core;

import java.util.ArrayList;
import java.util.List;

import es.rchavarria.einarcounts.R;

public class EinarVoices {

	private VoicePlayer player;
	private int currentVoiceStyle;
	private List<List<Integer>> voiceStyles;

	public EinarVoices(VoicePlayer player) {
		this.player = player;
		currentVoiceStyle = 0;
		voiceStyles = initVoiceStyles();
	}

	private List<List<Integer>> initVoiceStyles() {
		List<Integer> longVoices = new ArrayList<Integer>(10);
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
		
		List<Integer> clearVoices = new ArrayList<Integer>(10);
		clearVoices.add(R.raw.one_clear);
		clearVoices.add(R.raw.two_clear);
		clearVoices.add(R.raw.three_clear);
		clearVoices.add(R.raw.four_clear);
		clearVoices.add(R.raw.five_clear);
		clearVoices.add(R.raw.six_clear);
		clearVoices.add(R.raw.seven_clear);
		clearVoices.add(R.raw.eight_clear);
		clearVoices.add(R.raw.nine_clear);
		clearVoices.add(R.raw.ten_clear);
		
		List<Integer> shortVoices = new ArrayList<Integer>(10);
		shortVoices.add(R.raw.one_short);
		shortVoices.add(R.raw.two_short);
		shortVoices.add(R.raw.three_short);
		shortVoices.add(R.raw.four_short);
		shortVoices.add(R.raw.five_short);
		shortVoices.add(R.raw.six_short);
		shortVoices.add(R.raw.seven_short);
		shortVoices.add(R.raw.eight_short);
		shortVoices.add(R.raw.nine_short);
		shortVoices.add(R.raw.ten_short);
		
		List<List<Integer>> styles = new ArrayList<List<Integer>>(3);
		styles.add(longVoices);
		styles.add(clearVoices);
		styles.add(shortVoices);
		
		return styles;
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
			return voiceStyles.get(currentVoiceStyle).get(id - 1);

		} catch(Exception e) {}
		
		// got an error, update voice style
		currentVoiceStyle = (currentVoiceStyle + 1) % voiceStyles.size();
		return -1;
	}
}
