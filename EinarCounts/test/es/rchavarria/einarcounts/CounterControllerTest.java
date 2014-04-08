package es.rchavarria.einarcounts;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.rchavarria.einarcounts.core.Counter;

public class CounterControllerTest {

	private CounterController controller;

	@Before
	public void setUp() {
		Counter c = new Counter(10);
		controller = new CounterController(c);
	}
	
	@Test
	public void firstCallToNextStepReturns1() {
		assertEquals(controller.nextStep(), "1");
	}

}
