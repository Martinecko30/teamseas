package io.github.martinecko30.resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class ImageHandler {

    private Image mainImage = null;
    private BufferedImage bufferedImage = null;

    public int width, height;

    public ImageHandler(String path, int scaleX, int scaleY) {
        this.width = scaleX;
        this.height = scaleY;
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            Image modifiedImage = mainImage.getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
            mainImage = new ImageIcon(modifiedImage).getImage();
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
    }

    public ImageHandler(String path, int scale) {
        this.width = scale;
        this.height = scale;
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            Image modifiedImage = mainImage.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
            mainImage = new ImageIcon(modifiedImage).getImage();
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
    }

    public ImageHandler(String path) {
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
    }

    public ImageHandler() {}

    public Image getImage(String path, int scaleX, int scaleY) {
        this.width = scaleX;
        this.height = scaleY;
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            Image modifiedImage = mainImage.getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
            mainImage = new ImageIcon(modifiedImage).getImage();
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
        return mainImage;
    }

    public BufferedImage getBufferedImage(String path) {
        try {
            bufferedImage = ImageIO.read(getClass().getResource(path));
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
        return bufferedImage;
    }



    public Image getImage(String path, int scale) {
        this.width = scale;
        this.height = scale;
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
            Image modifiedImage = mainImage.getScaledInstance(scale, scale, Image.SCALE_SMOOTH);
            mainImage = new ImageIcon(modifiedImage).getImage();
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
        return mainImage;
    }

    public Image getImage(String path) {
        try {
            URL imageURL = this.getClass().getResource(path);
            mainImage = Toolkit.getDefaultToolkit().getImage(imageURL);
        } catch (Exception e) {
            System.out.println("An error occured - "+e.getMessage()+"\n-------------");
            e.printStackTrace();
        }
        return mainImage;
    }

    public BufferedImage rotateImageByDegrees(BufferedImage img, double angle) {

        double rads = Math.toRadians(angle);
        double sin = Math.abs(Math.sin(rads)), cos = Math.abs(Math.cos(rads));
        int w = img.getWidth();
        int h = img.getHeight();
        int newWidth = (int) Math.floor(w * cos + h * sin);
        int newHeight = (int) Math.floor(h * cos + w * sin);

        BufferedImage rotated = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotated.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - w) / 2, (newHeight - h) / 2);

        int x = w / 2;
        int y = h / 2;

        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();

        return rotated;
    }

    public Image getMainImage() {
        return mainImage;
    }

    public Image build() {
        return mainImage;
    }

    public Image buildBuffered() {
        return bufferedImage;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
