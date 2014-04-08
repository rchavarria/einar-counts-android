package es.rchavarria.einarcounts;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import es.rchavarria.einarcounts.core.Counter;
import es.rchavarria.einarcounts.core.EinarVoices;

public class CounterControllerTest {

	private CounterController controller;
	private Counter mockCounter;
	private EinarVoices mockVoices;

	@Before
	public void setUp() {
		mockCounter = mock(Counter.class);
		mockVoices = mock(EinarVoices.class)
				;
		controller = new CounterController(mockCounter, mockVoices);
	}
	
	@Test
	public void nextStepCallsCounterIncrementCountOnlyOnce() {
		controller.nextStep();
		
		verify(mockCounter, times(1)).incrementCount();
	}

}
