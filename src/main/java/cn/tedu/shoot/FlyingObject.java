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
        y = -height;
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

    //FlyingObject movement
    public abstract void step();

    //Detecting if an enemies have crossed the border
    public boolean isOutOfBounds(){
        return y>=World.HEIGHT;//If the enemy's y >= window height, it is out of bounds.
    }

    //Detecting Collisions/Assume `this` represents the enemy, and `other` represents either a Bullet or the Hero.
    public boolean isHit(FlyingObject other){
        int x1 = this.x - other.width;//x1=Enemies' x-bullets/Hero's width
        int x2 = this.x + this.width;//x2=Enemies' x+Enemies' width
        int y1 = this.y - other.height;//y1=Enemies' y-bullets/Hero's height
        int y2 = this.y + this.height;//y2=Enemies' y+Enemies' height
        int x = other.x;//x:Bullets/Hero's x
        int y = other.y;//y:Bullets/Hero's y

        return (x>=x1 && x<=x2) && (y>=y1 && y<=y2);//x is between x1 and x2,y is between y1 and y2
    }

    //FlyingObject go dead
    public void goDead(){
        state = DEAD;//Change the object's state to dead
    }
}
