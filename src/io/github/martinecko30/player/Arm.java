package io.github.martinecko30.player;

import io.github.martinecko30.main.BoundingBox;
import io.github.martinecko30.main.Main;
import io.github.martinecko30.resources.ImageHandler;

import java.awt.*;

public class Arm extends BoundingBox {
    public static int x, y, width, height;
    public double rotationDeg = 0;
    private Player player;

    public Arm(int x, int y, int width, int height, Player player) {
        super(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.player = player;
    }

    /*
    public void checkCollisions() {
        for(int i = 0; i< Main.trashList.size(); i++) {
            if(this.isOverlapping(Main.trashList.get(i))) {
                player.takeTrash(Main.trashList.get(i));
            }
        }
    }
    */

    public void moveArm(MouseAdapter mouseAdapter) {
        double dx = this.x - mouseAdapter.getX();
        double dy = this.y - mouseAdapter.getY();
        rotationDeg = Math.atan2(dy, dx);

        this.updateBoundingBox(x, y, width, height);
    }

    public double getRotationDeg() {
        return rotationDeg;
    }


    public void drawArm(Graphics g) {
        /*Graphics2D g2 = (Graphics2D) g;
        int cx = width / 2;
        int cy = height / 2;
        g2.translate(-cx, -cy);
        g2.rotate(rotationDeg);*/
        g.drawImage(new ImageHandler("scuba_diver_arm.png", width, height+10).build(), Arm.x, Arm.y, null);

        g.setColor(Color.red);
        if(Main.debugMode) {
            g.drawRect(x, y, width, height);
        }
    }
}
