package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject{
    private int xSpeed;
    private int ySpeed;
    private int awardType;
    public Bee(){
        super(60,51);
        xSpeed = 1;
        ySpeed = 2;
        Random rand = new Random();
        awardType = rand.nextInt(2);//Random number from 0 to 1
    }
    private int index = 1;
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
