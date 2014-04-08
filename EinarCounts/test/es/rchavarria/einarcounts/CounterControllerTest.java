package es.rchavarria.einarcounts;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CounterControllerTest {

	private CounterController controller;

	@Before
	public void setUp() {
		controller = new CounterController();
	}
	
	@Test
	public void firstCallToNextStepReturns1() {
		assertEquals(controller.nextStep(), "1");
	}

}
