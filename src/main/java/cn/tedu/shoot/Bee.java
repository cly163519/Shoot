package cn.tedu.shoot;

import java.util.Random;

public class Bee extends FlyingObject{
    private int xSpeed;
    private int ySpeed;
    private int awardType;
    public Bee(){
        width = 60;
        height = 51;
        xSpeed = 1;
        ySpeed = 2;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH-width);
        y = -height;
        awardType = rand.nextInt(2);//Random number from 0 to 1
    }
}
