package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class BigAirplane extends FlyingObject implements EnemyScore{
    private int speed;
    public BigAirplane(){
        super(66,89);
        speed = 2;
    }
    private int index = 1;
    public BufferedImage getImage(){
        if (isLive()) {
            return Images.bairs[0];
        }else if(isDead()){
            BufferedImage img = Images.bairs[index++];
            if(index==Images.bairs.length){
                state = REMOVE;
            }
            return img;
        }
        return null;
    }

    //Rewrite flying object movement
    public void step(){
        y += speed;//y+ means downward
    }

    public int getScore(){
        return 3; //Destroying a BigAirplane gives the player 3 points
    }
}
