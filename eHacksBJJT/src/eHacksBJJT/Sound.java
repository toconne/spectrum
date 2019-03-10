package eHacksBJJT;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	private Clip startMusic;
	private Clip gameMusic;
	private Clip missedPoint;
	private Clip gameOver;
	private Clip pointGet;
	
	public void loadSounds() {
		try {
			startMusic = AudioSystem.getClip();
			startMusic.open(AudioSystem.getAudioInputStream(new File("src/eHacksBJJT/sounds/startMusic.wav")));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			gameMusic = AudioSystem.getClip();
			gameMusic.open(AudioSystem.getAudioInputStream(new File("src/eHacksBJJT/sounds/loopingMusic.wav")));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			missedPoint = AudioSystem.getClip();
			missedPoint.open(AudioSystem.getAudioInputStream(new File("src/eHacksBJJT/sounds/missedPoint.wav")));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			gameOver = AudioSystem.getClip();
			gameOver.open(AudioSystem.getAudioInputStream(new File("src/eHacksBJJT/sounds/gameOver.wav")));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		try {
			pointGet = AudioSystem.getClip();
			pointGet.open(AudioSystem.getAudioInputStream(new File("src/eHacksBJJT/sounds/pointGet.wav")));
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public Clip getGameOver() {
		return gameOver;
	}
	public Clip getMissedPoint() {
		return missedPoint;
	}
	public Clip getStartMusic() {
		return startMusic;
	}
	public Clip getGameMusic() {
		return gameMusic;
	}
	public Clip getPointGet() {
		return pointGet;
	}
	
}
