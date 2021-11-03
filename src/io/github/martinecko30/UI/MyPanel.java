package io.github.martinecko30.UI;

import io.github.martinecko30.fishes.Fish;
import io.github.martinecko30.main.DrawImages;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.player.Arm;
import io.github.martinecko30.player.MouseAdapter;
import io.github.martinecko30.player.MyKeyAdapter;
import io.github.martinecko30.player.Player;
import io.github.martinecko30.trash.Trash;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

class MyPanel extends JPanel implements ActionListener {
    private DrawImages drawImages;
    private Player player;
    private Timer timer;
    private MyKeyAdapter keyAdapter;
    private MyButton myButton;
    private Arm arm = null;
    private MouseAdapter mouseAdapter;

    public MyPanel(DrawImages drawImages, Player player, Arm arm, MouseAdapter mouseAdapter) {
        this.timer = new Timer(10, this);
        this.drawImages = drawImages;
        this.player = player;
        this.keyAdapter = new MyKeyAdapter();
        this.arm = arm;
        this.mouseAdapter = mouseAdapter;

        setPreferredSize(new Dimension(Main.WIDTH, Main.HEIGHT));
        setBackground(Main.COLOR);

        myButton = new MyButton("Start",
                300, 300, 100, 50, 30,
                Color.BLUE, Color.WHITE);

        this.addMouseMotionListener(mouseAdapter);
        this.setFocusable(true);
        this.addKeyListener(this.keyAdapter);
        this.timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Main.COLOR);
        drawImages.drawBackground(g);
        drawImages.drawPlayer(g);
        drawImages.drawScore(g);
        arm.drawArm(g);
        myButton.drawButton(g);

        if(Main.trashList.size() >= 1) {
            for (Trash trash : Main.trashList) {
                trash.drawTrash(g);
            }
        }

        if(Main.fishList.size() >= 1) {
            for (Fish fish : Main.fishList) {
                fish.drawFish(g);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int keyCode = keyAdapter.getKeyCode();
        player.move(keyCode);
        if(keyAdapter.getConsoleKey())
            Main.debugMode = !Main.debugMode;

        if(!Main.ended){
            player.movePlayer();
            player.checkCollisions();
            player.checkInbounds();

            Object actionSource = e.getSource();
            System.out.println(actionSource);

            arm.moveArm(mouseAdapter);

            for (int i=0;i<Main.trashList.size();i++) {
                Main.trashList.get(i).checkIfInbound();
                Main.trashList.get(i).moveTrash();
            }


            for (int i=0;i<Main.fishList.size();i++) {
                Main.fishList.get(i).checkIfInbound();
            }
            for (Fish fish : Main.fishList) {
                fish.moveTrash();
            }

            repaint();
        } else if (Main.ended){
            timer.stop();
        }
    }
}