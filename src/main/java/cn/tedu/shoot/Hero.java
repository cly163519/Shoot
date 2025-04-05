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
        if(fire>0){//Double fire
            Bullet[] bs = new Bullet[2];//Creates an array with 2 bullets
            bs[0] = new Bullet[];
            return bs;
        }else{ //Single fire
            Bullet[] bs = new Bullet[1];//Creates an array with 1 bullets
            return bs;
        }
    }
}
