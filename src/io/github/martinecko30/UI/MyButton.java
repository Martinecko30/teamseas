package io.github.martinecko30.UI;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    private String text;
    private int x, y, width, height, textSize;
    private Color backgroundColor, textColor;

    public MyButton(String text, int x, int y, int width, int height, int textSize, Color backgroundColor, Color textColor) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.textSize = textSize;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    public void drawButton(Graphics g) {
        g.setColor(backgroundColor);
        g.fillRect(x, y, width, height);
        g.setColor(textColor);
        g.setFont(new Font("Dialog", Font.PLAIN, textSize));

        FontMetrics metrics = g.getFontMetrics(new Font("Dialog", Font.PLAIN, textSize));
        int cX = x+ (width-metrics.stringWidth(text))/2;
        int cY = y+ ((height-metrics.getHeight())/2)+metrics.getAscent();
        g.drawString(text, cX, cY);
    }
}