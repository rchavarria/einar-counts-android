Tasks
=====

+ Play the correct voice for the displayed number
	+ EinarVoices get a Player interface in the constructor
	+ A Player interface implementor is the only class with a Context (Activity) that really plays sounds)
	+ EinarVoices just generates / computes the resource id for each sound
	+ EinarVoices can stop implementing an interface, it doesn't need a Context in the constructor
	
+ EinarVoices manages different voices styles
	+ getVoiceResource chooses voices from different lists (long, short, clear, ...)
	+ getVoiceResource changes voice style each time it gets an error
	+ ¿?
	
- Manage sounds with SoundPool, or SoundManager, or something like that. Stop managing sounds with MediaPlayer.
	- I remember there is something to manage a list of sounds
	- An example can be found: http://www.edumobile.org/android/android-programming-tutorials/sound-pool-example-in-android-development/
	- 
	
- more?
