package cn.tedu.shoot;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Images {
    public static BufferedImage sky;//Sky picture
    public static BufferedImage bullet;//Bullet picture
    public static BufferedImage[] heros;//Hero pictures array
    public static BufferedImage[] airs;//Airplane pictures array
    public static BufferedImage[] bairs;//BigAirplane pictures array
    public static BufferedImage[] bees;//Bee pictures array
    public static BufferedImage start;//Startup picture
    public static BufferedImage pause;//Pause picture
    public static BufferedImage gameover;//Game is over

    static{  //initialize pictures
        start = readImage("start.png");
        pause = readImage("pause.png");
        gameover = readImage("gameover.png");

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
/*
    public static BufferedImage readImage(String fileName){
        try{
            BufferedImage img = ImageIO.read(FlyingObject.class.getResource(fileName));
            return img;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

 */
public static BufferedImage readImage(String fileName) {
    try (InputStream imgStream = Images.class.getClassLoader().getResourceAsStream("images/" + fileName)) {
        if (imgStream == null) {
            System.out.println("Resource not found: images/" + fileName);
            throw new RuntimeException("Image not found: " + fileName);
        }
        return ImageIO.read(imgStream);
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to load image: " + fileName);
    }
}



}
