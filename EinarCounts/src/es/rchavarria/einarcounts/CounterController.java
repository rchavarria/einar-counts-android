package es.rchavarria.einarcounts;

import es.rchavarria.einarcounts.core.Counter;

public class CounterController {

	private Counter counter;

	public CounterController(Counter counter) {
		this.counter = counter;
	}
	
	public String nextStep() {
		return counter.incrementCount();
	}
}
