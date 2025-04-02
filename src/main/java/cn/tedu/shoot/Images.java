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
        heros[0] = readImage("hero0.png");
        heros[1] = readImage("hero1.png");

        airs = new BufferedImage[5];
        bairs = new BufferedImage[5];
        bees = new BufferedImage[5];
        airs[0] = readImage("airplane.png");
        bairs[0] = readImage("bigairplane.png");
        bees[0] = readImage("bee.png");
        for(int i=1;i<airs.length;i++){
            airs[i] = readImage("bom"+i+".png");
            bairs[i] = readImage("bom"+i+".png");
            bees[i] = readImage("bom"+i+".png");
        }
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
