package cn.tedu.shoot;

public class Sky extends FlyingObject{
    private int speed;
    private int y1;//second sky picture
    public Sky(){
        width = World.WIDTH;
        height = World.HEIGHT;
        x = 0;
        y = 0;
        speed = 1;
        y1 = -700;
    }
}
