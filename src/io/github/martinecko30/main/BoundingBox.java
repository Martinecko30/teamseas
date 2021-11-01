package io.github.martinecko30.main;

import java.awt.*;

public class BoundingBox extends Rectangle {

    public int x, y, width, height;
    private Point topRight = new Point(x+width, y), bottomLeft = new Point(x, y-height);

    public BoundingBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.topRight.setLocation(x+width, y);
        this.bottomLeft.setLocation(x, y-height);
    }

    public BoundingBox(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;
    }

    public void updateBoundingBox(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.topRight.setLocation(x+width, y);
        this.bottomLeft.setLocation(x, y-height);
    }

    public void updateBoundingBox(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.width = size;
        this.height = size;
        this.topRight.setLocation(x+width, y);
        this.bottomLeft.setLocation(x, y-height);
    }

    public boolean isOverlapping(BoundingBox other) {
        if (this.topRight.getY() < other.bottomLeft.getY() || this.bottomLeft.getY() > other.topRight.getY()) {
            return false;
        }
        if (this.topRight.getX() < other.bottomLeft.getX() || this.bottomLeft.getX() > other.topRight.getX()) {
            return false;
        }
        return true;
    }
}
