package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Bee extends FlyingObject implements EnemyAward{
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

    //Rewrite flying object movement
    public void step(){
        x += xSpeed;//x+ means left or right
        y += ySpeed;//y+ means downwards
        if (x <= 0 || x >= World.WIDTH - width) {//If the x-coordinate is less than 0, or greater than the width of the window width-bee's width, move in the opposite direction
            xSpeed *= -1;//Toggle direction, positive to negative, negative to positive
        }
    }
        //Rewrite getAwardType()
        public int getAwardType(){
            return awardType;
    }
}
