package cn.tedu.shoot;

import java.util.Random;
import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    public static final int LIVE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2;
    protected int state = LIVE;


    protected int width;
    protected int height;
    protected int x;
    protected int y;
    //Provided for Airplane,BigAirplane,Bee
    // The three types of enemies have different widths and heights, so parameters are required.
    // Since the x/y coordinates are the same, no parameters are needed.
    public FlyingObject(int width,int height){
        this.width = width;
        this.height = height;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH-width);
        y = height;
    }
    //Provided for Hero, Sky, Bullet
    //Hero,Sky and Bullet have different width, height, x and y, so parameters are required.
    public FlyingObject(int width, int height, int x,int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }
    public abstract BufferedImage getImage();

    //Determine whether the object is alive
    public boolean isLive(){
        return state == LIVE;
    }
    public boolean isDead(){
        return state == DEAD;
    }
    public boolean isRemove(){
        return state == REMOVE;
    }
}
