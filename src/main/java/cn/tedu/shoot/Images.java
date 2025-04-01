package cn.tedu.shoot;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Images {
    public static BufferedImage sky;
    public static BufferedImage bullet;
    public static BufferedImage[] heros;
    public static BufferedImage[] airs;
    public static BufferedImage[] bairs;
    public static BufferedImage[] bees;
    static{//initialize pictures
        sky = readImage("background.png");
        bullet = readImage("bullet.png");
        heros = new BufferedImage[2];

    }

    public static BufferedImage readImage(String fileName){
        try{
            BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
            return img;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
