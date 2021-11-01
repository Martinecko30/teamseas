package io.github.martinecko30.main;

import io.github.martinecko30.UI.UI;
import io.github.martinecko30.enums.Difficulty;
import io.github.martinecko30.fishes.Fish;
import io.github.martinecko30.player.Player;
import io.github.martinecko30.trash.Trash;
import io.github.martinecko30.trash.Spawner;

import java.awt.*;
import java.util.ArrayList;

public class Main {

    public static int WIDTH = 800;
    public static int HEIGHT = 800;
    public static Color COLOR = new Color(0, 128,230);
    public static Difficulty difficulty = Difficulty.EASY;
    public static Player player = new Player();
    public static boolean ended = false;

    public static boolean debugMode = false;

    public static ArrayList<Trash> trashList = new ArrayList<>();
    public static ArrayList<Fish> fishList = new ArrayList<>();

    public static void main(String[] args) {
        ended = false;
        UI.main();
        Spawner spawner = new Spawner(difficulty, player);
    }

    public Main() {
        ended = false;
        UI.main();
        Spawner spawner = new Spawner(difficulty, player);
    }

    public static void gameOver() {
        ended = true;
    }
}
