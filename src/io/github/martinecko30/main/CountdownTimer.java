package io.github.martinecko30.main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownTimer implements ActionListener {
    private Timer timer;
    int timerSeconds = 5;

    public CountdownTimer(int seconds) {
        this.timerSeconds = seconds;
        this.timer = new Timer(seconds, this);
    }

    public void setTimer(int seconds) {
        this.timerSeconds = seconds;
        this.timer = new Timer(seconds, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ended();
    }

    public boolean ended(){
        if(timerSeconds<=0) {
            return true;
        }
        return false;
    }
}