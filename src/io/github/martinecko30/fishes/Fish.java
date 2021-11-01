package io.github.martinecko30.fishes;

import io.github.martinecko30.main.BoundingBox;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.player.Player;
import io.github.martinecko30.resources.ImageHandler;

import java.awt.*;

public class Fish extends BoundingBox {

    private int positionY, positionX, width, height;
    private int moveSpeed = 2;
    Player player = null;

    public Fish(int x, int y, int size, Player player) {
        super(x, y, size, size);
    }

    public Fish(int x, int y, int width, int height, Player player) {
        super(x, y, width, height);
    }

    public void moveTrash() {
        positionX = positionX - moveSpeed;
    }

    public void drawFish(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        ImageHandler imageHandler = new ImageHandler();
        g2.drawImage(imageHandler.getImage("plastic_bottle_1.png", 100), this.positionX, this.positionY,width,height, null);
    }

    public void moveAndDrawFish(Graphics g) {
        positionX = positionX - 10;
        Graphics2D g2 = (Graphics2D) g;
        ImageHandler imageHandler = new ImageHandler();
        g2.drawImage(imageHandler.getImage("plastic_bottle_1.png", 100), this.positionX, this.positionY,width,height, null);
    }

    public void checkIfInbound() {
        if(positionX<=-width){
            remove();
        }
    }

    public void remove() {
        Main.trashList.remove(this);
    }
}
