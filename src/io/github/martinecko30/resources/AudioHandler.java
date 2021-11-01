package io.github.martinecko30.resources;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class AudioHandler {

    Clip audio;

    public void playSound(String sound){
        try {
            URL soundURL = this.getClass().getResource(sound);
            try (Clip clip = AudioSystem.getClip()) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL);
                clip.open(ais);
                clip.start();
            }
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
    }
}
