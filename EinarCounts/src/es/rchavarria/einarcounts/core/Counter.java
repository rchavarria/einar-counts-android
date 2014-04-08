package es.rchavarria.einarcounts.core;

public class Counter {

	private int countUpTo;
	private int counter = 0;
	
	public Counter(int countUpTo) {
		this.countUpTo = countUpTo;
	}
	
	public String incrementCount() {
		counter++;
		
		if(counter > countUpTo) {
			counter = 0;
			return "#";
		}
		
		return Integer.valueOf(counter).toString();
	}

}
