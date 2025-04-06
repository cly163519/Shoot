package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Sky extends FlyingObject{
    private int speed;
    private int y1;//The second sky picture
    public Sky(){
        super(World.WIDTH,World.HEIGHT,0,0);
        speed = 1;
        y1 = -700;
    }
    public BufferedImage getImage(){
        return Images.sky;
    }
    public int getY1(){
        return y1;
    }

    //Rewrite flying object movement
    public void step(){
        y += speed;
        y1 += speed;
        if(y>=World.HEIGHT){//If y>=World.HEIGHT,means it has moved to the bottom
            y = -World.HEIGHT;//y coordinator modified to -World.HEIGHT would mean moving to the top of the window
        }
        if(y1>=World.HEIGHT){ //Same logic to y
            y1 = -World.HEIGHT;
        }
    }

}
