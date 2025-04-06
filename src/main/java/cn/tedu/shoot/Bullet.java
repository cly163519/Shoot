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

    //Rewrite flying object movement
    public void step(){
        y -= speed;//y- means upward
    }

    //Rewrite isOutOfBounds(), and Detect if bullets have crossed the border
    public boolean isOutOfBounds(){
        return y<=-height;//If bullet's y <= -bullet's height, it is out of bounds.
    }

}
