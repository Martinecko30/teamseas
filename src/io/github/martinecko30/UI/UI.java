package io.github.martinecko30.UI;

import io.github.martinecko30.main.DrawImages;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.player.MouseAdapter;
import io.github.martinecko30.player.Player;

import java.awt.*;

public class UI {
    public static void main() {
        EventQueue.invokeLater(() -> {
            MouseAdapter mouseAdapter = new MouseAdapter();
            DrawImages drawImages = new DrawImages(mouseAdapter);
            Player player = Main.player;
            MyPanel panel = new MyPanel(drawImages, player, player.arm, mouseAdapter);
            new MyFrame(panel);
        });
    }
}