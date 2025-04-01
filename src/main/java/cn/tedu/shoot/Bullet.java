package cn.tedu.shoot;

public class Bullet extends FlyingObject{
    private int speed;
    public Bullet(int x,int y){
        width = 8;
        height = 20;
        this.x = x;
        this.y = y;
        speed = 3;
    }

}
