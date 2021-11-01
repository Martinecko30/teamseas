package io.github.martinecko30.trash;

import io.github.martinecko30.main.BoundingBox;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.player.Player;
import io.github.martinecko30.resources.ImageHandler;

import java.awt.*;

public class Trash extends BoundingBox {
    private int positionY, positionX, width, height;
    private int trashMoveSpeed = 2;
    Player player = null;

    public Trash(int x, int y, int size, Player player) {
        super(x, y, size);
        this.positionX = x;
        this.positionY = y;
        this.width = size;
        this.height = size;
        this.player = player;
    }

    public Trash(int x, int y, int width, int height, Player player) {
        super(x, y, width, height);
        this.positionX = x;
        this.positionY = y;
        this.width = width;
        this.height = height;
        this.player = player;
    }

    public void moveTrash() {
        positionX = positionX - trashMoveSpeed;
        this.updateBoundingBox(positionX,positionY, width, height);
    }

    public void drawTrash(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        ImageHandler imageHandler = new ImageHandler();
        g2.drawImage(imageHandler.getImage("plastic_bottle_1.png", 100), this.positionX, this.positionY,width,height, null);

        if(Main.debugMode) {
            g.drawRect(this.positionX, this.positionY, this.width, this.height);
        }
    }

    public void moveAndDrawTrash(Graphics g) {
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
