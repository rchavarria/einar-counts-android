package es.rchavarria.einarcounts.core;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import es.rchavarria.einarcounts.R;

public class EinarVoicesTest {

	private EinarVoices voices;
	private VoicePlayer mockPlayer;
	
	@Before
	public void setUp() {
		mockPlayer = mock(VoicePlayer.class);
		voices = new EinarVoices(mockPlayer);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void playWithNullIdentifierThrowsException() {
		voices.play(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void playWithEmptyIdentifierThrowsException() {
		voices.play("");
	}
	
	@Test
	public void playResourcesAccordingToNumbers() {
		String[] numbers = new String[] {
				"#", 
				"1", 
				"2", 
				"3", 
				"4", 
				"5", 
				"6", 
				"7", 
				"8", 
				"9", 
				"10" 
			};
		int[] resources = new int[] { 
				R.raw.error, 
				R.raw.one_long, 
				R.raw.two_long, 
				R.raw.three_long, 
				R.raw.four_long, 
				R.raw.five_long, 
				R.raw.six_long, 
				R.raw.seven_long, 
				R.raw.eight_long, 
				R.raw.nine_long, 
				R.raw.ten_long 
			};

		for(int i = 0; i < numbers.length; i++) {
			voices.play(numbers[i]);
			verify(mockPlayer).play(resources[i]);
		}
	}

}
