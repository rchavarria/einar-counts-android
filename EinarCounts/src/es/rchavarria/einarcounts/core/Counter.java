package es.rchavarria.einarcounts.core;

public class Counter {

	private int counter = 0;
	
	public String incrementCount() {
		counter++;
		
		if(counter > 10) {
			counter = 0;
			return "#";
		}
		
		return Integer.valueOf(counter).toString();
	}

}
