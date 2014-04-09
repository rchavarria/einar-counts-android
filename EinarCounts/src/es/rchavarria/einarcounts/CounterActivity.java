package es.rchavarria.einarcounts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import es.rchavarria.einarcounts.core.Counter;
import es.rchavarria.einarcounts.core.EinarVoices;
import es.rchavarria.einarcounts.core.SimpleVoicePlayer;

public class CounterActivity extends Activity {

	private CounterController controller;
	
	private void configureController() {
		Counter counter = new Counter(10);
		SimpleVoicePlayer player = new SimpleVoicePlayer(this);
		EinarVoices voices = new EinarVoices(player);
		
		controller = new CounterController(counter, voices);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		configureController();
		
		setContentView(R.layout.activity_counter);
	}

	public void counterTouched(View v) {
		TextView txt = (TextView) findViewById(R.id.txtCounter);
		
		txt.setText(controller.nextStep());
		txt.invalidate();
	}
}
