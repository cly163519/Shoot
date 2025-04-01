package cn.tedu.shoot;

import java.util.Random;

public class FlyingObject {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    //Provided for Airplane,BigAirplane,Bee
    public FlyingObject(int width,int height){
        this.width = width;
        this.height = height;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH-width);
        y = -height;
    }
    //Provided for Hero, Sky, Bullet
    public FlyingObject(int width, int height, int x,int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

}
