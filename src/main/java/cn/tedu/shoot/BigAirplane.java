package cn.tedu.shoot;

import java.util.Random;

public class BigAirplane extends FlyingObject {
    private int speed;
    public BigAirplane(){
        width = 66;
        height = 89;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH-width);
        y = -height;
        speed = 2;
    }

}
