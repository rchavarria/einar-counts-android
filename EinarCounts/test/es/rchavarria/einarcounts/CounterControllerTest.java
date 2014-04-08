package es.rchavarria.einarcounts;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import es.rchavarria.einarcounts.core.Counter;
import es.rchavarria.einarcounts.core.Voices;

public class CounterControllerTest {

	private CounterController controller;
	private Counter mockCounter;
	private Voices mockVoices;

	@Before
	public void setUp() {
		mockCounter = mock(Counter.class);
		mockVoices = mock(Voices.class);
		
		controller = new CounterController(mockCounter, mockVoices);
	}
	
	@Test
	public void nextStepCallsCounterIncrementCountOnlyOnce() {
		controller.nextStep();
		
		verify(mockCounter, times(1)).incrementCount();
	}
	
	@Test
	public void nextStepCallsEinarVoicesPlayOnlyOnce() {
		controller.nextStep();
		
		verify(mockVoices, times(1)).play(anyString());
	}

}
