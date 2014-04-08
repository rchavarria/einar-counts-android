package es.rchavarria.einarcounts.core;

import org.junit.Before;
import org.junit.Test;

public class EinarVoicesTest {

	private EinarVoices voices;
	
	@Before
	public void setUp() {
		voices = new EinarVoices();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void playWithNullIdentifierThrowsException() {
		voices.play(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void playWithEmptyIdentifierThrowsException() {
		voices.play("");
	}

}
