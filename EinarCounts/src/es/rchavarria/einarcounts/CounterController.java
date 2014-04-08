package es.rchavarria.einarcounts;

import es.rchavarria.einarcounts.core.Counter;

public class CounterController {

	private Counter counter;

	public CounterController() {
		counter = new Counter(10);
	}
	
	public String nextStep() {
		return counter.incrementCount();
	}
}
