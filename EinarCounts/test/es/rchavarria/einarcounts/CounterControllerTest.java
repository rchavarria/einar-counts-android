package es.rchavarria.einarcounts;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import es.rchavarria.einarcounts.core.Counter;

public class CounterControllerTest {

	private CounterController controller;
	private Counter mockCounter;

	@Before
	public void setUp() {
		mockCounter = mock(Counter.class);
		controller = new CounterController(mockCounter);
	}
	
	@Test
	public void nextStepCallsCounterIncrementCountOnlyOnce() {
		controller.nextStep();
		
		verify(mockCounter, times(1)).incrementCount();
	}

}
