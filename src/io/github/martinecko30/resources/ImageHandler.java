package io.github.martinecko30.resources;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageHandler {

    private Image mainImage = null;

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

    public Image getMainImage() {
        return mainImage;
    }

    public Image build() {
        return mainImage;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
