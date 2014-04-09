package es.rchavarria.einarcounts;

import es.rchavarria.einarcounts.core.Counter;
import es.rchavarria.einarcounts.core.EinarVoices;

public class CounterController {

	private Counter counter;
	private EinarVoices voices;

	public CounterController(Counter counter, EinarVoices voices) {
		this.counter = counter;
		this.voices = voices;
	}
	
	public String nextStep() {
		String currentCounter = counter.incrementCount();
		voices.play(currentCounter);
		
		return currentCounter;
	}
}
