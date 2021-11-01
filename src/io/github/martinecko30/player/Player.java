package io.github.martinecko30.player;

import io.github.martinecko30.main.BoundingBox;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.resources.AudioHandler;
import io.github.martinecko30.trash.Trash;

public class Player extends BoundingBox {

    private AudioHandler audioHandler = new AudioHandler();

    public static int positionY = Main.HEIGHT/2, positionX = Main.WIDTH/3-100;
    private String direction = "steady";
    public static int score = 0;
    private int playerMoveSpeed = 4;
    public boolean blockMovementUp = false, blockMovementDown = true;

    public static int width = 145, height = 50;

    public Arm arm = null;

    public Player() {
        super(positionX, positionY, width, height);
        arm = new Arm(positionX/2+20, positionY/2, 60, 30, this);
    }

    public void move(int keyCode) {
        switch (keyCode) {
            case 38:
                direction = "up";
                break;
            case 40:
                direction = "down";
                break;
            case 0:
                direction = "steady";
                break;
        }
    }

    public void movePlayer() {
        if(direction.equals("up") && !blockMovementUp) {
            positionY = positionY - playerMoveSpeed;
        } else if(direction.equals("down") && !blockMovementDown) {
            positionY = positionY + playerMoveSpeed;
        }
        this.updateBoundingBox(positionX, positionY, width, height);
        arm.updateBoundingBox(arm.x, arm.y, arm.width, arm.height);
    }

    public void checkCollisions() {
        for(int i=0;i<Main.trashList.size();i++) {
            if(this.isOverlapping(Main.trashList.get(i))) {
                this.takeTrash(Main.trashList.get(i));
            }
        }
    }

    public void checkInbounds() {
        if(positionY<5) {
            blockMovementUp = true;
        } else {
            blockMovementUp = false;
        }

        if(positionY+height>Main.HEIGHT-5) {
            blockMovementDown = true;
        } else {
            blockMovementDown = false;
        }
    }

    public void takeTrash(Trash trash) {
        trash.remove();
        audioHandler.playSound("trashPickup.mp3");
        score++;
    }
}
