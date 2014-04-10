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
	public void playAnErrorVoice() {
		voices.play("#");
		verify(mockPlayer, times(1)).play(R.raw.error);
	}
	
	@Test
	public void playResourcesAccordingToNumbers() {
		Object[][] numberResourcesMapping = new Object[][] {
				new Object[] { "#", R.raw.error },
				new Object[] { "1", R.raw.one_long },
				new Object[] { "2", R.raw.two_long },
				new Object[] { "3", R.raw.three_long },
				new Object[] { "4", R.raw.four_long },
				new Object[] { "5", R.raw.five_long },
				new Object[] { "6", R.raw.six_long },
				new Object[] { "7", R.raw.seven_long },
				new Object[] { "8", R.raw.eight_long },
				new Object[] { "9", R.raw.nine_long },
				new Object[] { "10", R.raw.ten_long },
				new Object[] { "#", R.raw.error },
				new Object[] { "1", R.raw.one_clear },
				new Object[] { "2", R.raw.two_clear },
				new Object[] { "3", R.raw.three_clear },
				new Object[] { "4", R.raw.four_clear },
				new Object[] { "5", R.raw.five_clear },
				new Object[] { "6", R.raw.six_clear },
				new Object[] { "7", R.raw.seven_clear },
				new Object[] { "8", R.raw.eight_clear },
				new Object[] { "9", R.raw.nine_clear },
				new Object[] { "10", R.raw.ten_clear },
				new Object[] { "#", R.raw.error },
				new Object[] { "1", R.raw.one_short },
				new Object[] { "2", R.raw.two_short },
				new Object[] { "3", R.raw.three_short },
				new Object[] { "4", R.raw.four_short },
				new Object[] { "5", R.raw.five_short },
				new Object[] { "6", R.raw.six_short },
				new Object[] { "7", R.raw.seven_short },
				new Object[] { "8", R.raw.eight_short },
				new Object[] { "9", R.raw.nine_short },
				new Object[] { "10", R.raw.ten_short }
		};
		
		for(int i = 0; i < numberResourcesMapping.length; i++) {
			String number = (String) numberResourcesMapping[i][0];
			if("#".equals(number)) {
				continue;
			}
			
			voices.play(number);
			verify(mockPlayer).play((Integer) numberResourcesMapping[i][1]);
		}
	}

}
