package io.github.martinecko30.player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {

    private int keyCode = KeyEvent.VK_UP;

    private boolean pressedConsoleKey = false;
    private boolean pressedConsoleKeyCode = false;

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() != 192) {
            keyCode = e.getKeyCode();
        } else {
            pressedConsoleKey = !pressedConsoleKey;
            pressedConsoleKeyCode = !pressedConsoleKeyCode;
        }
    }

    public int getKeyCode(){
        return keyCode;
    }

    public boolean getConsoleKey(){
        if(pressedConsoleKeyCode) {
            pressedConsoleKeyCode = false;
            return pressedConsoleKey;
        } else
            return false;
    }
}