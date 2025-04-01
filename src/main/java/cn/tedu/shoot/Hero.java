package cn.tedu.shoot;

public class Hero extends FlyingObject{
    private int life;
    private int fire;
    public Hero(){
        super(97,139,140,400);
        life = 3;
        fire = 0;
    }
}
