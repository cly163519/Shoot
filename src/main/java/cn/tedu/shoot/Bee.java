package cn.tedu.shoot;

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
}
