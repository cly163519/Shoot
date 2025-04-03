package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject{
    private int speed;
    public Bullet(int x,int y){
        super(8,20,x,y);
        speed = 3;
    }
    public BufferedImage getImage() {
       if(isLive()){
           return Images.bullet;
       }
       if(isDead()){
           state = REMOVE;
       }
           return null;
       }
}
