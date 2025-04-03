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
}
