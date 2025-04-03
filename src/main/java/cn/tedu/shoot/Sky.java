package cn.tedu.shoot;

import java.awt.image.BufferedImage;

public class Sky extends FlyingObject{
    private int speed;
    private int y1;//second sky picture
    public Sky(){
        super(World.WIDTH,World.HEIGHT,0,0);
        speed = 1;
        y1 = -700;
    }
    public BufferedImage getImage(){
        return Images.sky;

    }
}
