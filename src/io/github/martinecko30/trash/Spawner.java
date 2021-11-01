package io.github.martinecko30.trash;

import io.github.martinecko30.enums.Difficulty;
import io.github.martinecko30.fishes.Fish;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.player.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Spawner implements ActionListener{

    private Timer timer;
    private Difficulty difficulty;
    private Random random = new Random();
    private Player player = null;
    private int delayToSpawnTrash = 3;

    public Spawner(Difficulty difficulty, Player player) {
        this.timer = new Timer(delayToSpawnTrash*1000, this);
        this.difficulty = difficulty;
        this.player = player;
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Main.ended)
            return;

        if(difficulty == Difficulty.EASY) {
            Trash trash = new Trash(Main.WIDTH, 30+random.nextInt(Main.HEIGHT-80), 60, player);
            Main.trashList.add(trash);
            //Fish fish = new Fish(Main.WIDTH, 30+random.nextInt(Main.HEIGHT-80), 60, player);
            //Main.fishList.add(fish);
        }
    }
}
