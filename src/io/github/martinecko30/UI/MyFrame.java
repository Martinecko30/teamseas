package io.github.martinecko30.UI;

import io.github.martinecko30.player.MouseAdapter;
import io.github.martinecko30.resources.ImageHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class MyFrame extends JFrame {
    public MyFrame(MyPanel myPanel) {
        setVisible(true);
        setTitle("#TeamSeas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(new ImageHandler("plastic_bottle_1.png", 1000, 1000).build(),
                new Point(0, 0), "cursor");
        setIconImage(new ImageHandler("teamseasicon.png", 800).build());
        setCursor(cursor);
        add(myPanel);
        pack();
    }
}