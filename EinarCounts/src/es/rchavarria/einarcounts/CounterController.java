package es.rchavarria.einarcounts;

import es.rchavarria.einarcounts.core.Counter;
import es.rchavarria.einarcounts.core.Voices;

public class CounterController {

	private Counter counter;
	private Voices voices;

	public CounterController(Counter counter, Voices voices) {
		this.counter = counter;
		this.voices = voices;
	}
	
	public String nextStep() {
		String currentCounter = counter.incrementCount();
		voices.play(currentCounter);
		
		return currentCounter;
	}
}
