package io.github.martinecko30.main;

import io.github.martinecko30.player.Arm;
import io.github.martinecko30.player.MouseAdapter;
import io.github.martinecko30.player.Player;
import io.github.martinecko30.resources.ImageHandler;

import java.awt.*;

public class DrawImages {

    private ImageHandler imageHandler = new ImageHandler();
    private MouseAdapter mouseAdapter = null;

    public DrawImages(MouseAdapter mouseAdapter) {
        this.mouseAdapter = mouseAdapter;
    }

    public void drawBackground(Graphics g) {
        Image background1 = new ImageHandler("background.png", Main.WIDTH, Main.HEIGHT).build();
        g.drawImage(background1, 0, 0,null );
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        String s = String.valueOf(Player.score);
        g.setFont(new Font("Dialog", Font.PLAIN, 50));
        g.drawString(s, (Main.WIDTH/2)-((s.length()/2)*20), 45);
    }

    public void drawPlayer(Graphics g) {
        g.setColor(Color.red);
        g.drawImage(imageHandler.getImage("scuba_diver_default.png",
                190, 180),
                Player.positionX, Player.positionY-50, null);

        if(Main.debugMode) {
            g.drawRect(Player.positionX, Player.positionY, Player.width, Player.height);
        }
    }
}
