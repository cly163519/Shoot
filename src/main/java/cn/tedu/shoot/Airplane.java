package cn.tedu.shoot;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Airplane extends FlyingObject {
    private int speed;
    public Airplane(){
        super(48,50);
        speed = 2;
    }
    private int index = 1;//Bom pictures index from 1
    public BufferedImage getImage(){
        if (isLive()) {
            return Images.bees[0];
        }else if(isDead()){
            BufferedImage img = Images.bees[index++];
            if(index==Images.bees.length){
                state = REMOVE;
            }
            return img;
        }
        return null;
    }
}
