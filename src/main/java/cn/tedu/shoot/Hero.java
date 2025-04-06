package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
    private int life;
    private int fire;
    public Hero(){
        super(97,139,140,400);
        life = 3;
        fire = 0;
    }
    private int index = 0;
    public BufferedImage getImage(){
        return Images.heros[index++%2];
    }
    // The hero aircraft fires bullets, i.e., creates bullet objects
    public Bullet[] shoot(){
        int xStep = this.width/4;//1/4 of Hero's width
        int yStep = 20;//20 is a fixed number
        if(fire>0){//Double fire
            Bullet[] bs = new Bullet[2];//Creates an array with 2 bullets
            bs[0] = new Bullet(this.x+1*xStep,this.y-yStep);//x:Hero's x coordinate+1/4 of Hero's x coordinate
            bs[1] = new Bullet(this.x+3*xStep,this.y-yStep);
            fire -= 2;//Firing a double fire reduces the fire value by 2
            return bs;
        }else{ //Single fire
            Bullet[] bs = new Bullet[1];//Creates an array with 1 bullets
            bs[0] = new Bullet(this.x+2*xStep,this.y-yStep);
            return bs;
        }
    }
}
