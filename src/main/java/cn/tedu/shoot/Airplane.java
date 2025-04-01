package cn.tedu.shoot;
import java.util.Random;

public class Airplane extends FlyingObject {
    private int speed;
    public Airplane(){
        width = 48;
        height = 50;
        Random rand = new Random();
        x = rand.nextInt(World.WIDTH-width);
        y = -height;
        speed = 2;
    }
}
