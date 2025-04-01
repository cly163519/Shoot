package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class World {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    private Sky sky = new Sky();
    private Hero hero = new Hero();
    private FlyingObject[] enemies = {};//Contains Airplane,BigAirplane,Bee
    private Bullet[] bullets = {};

    public static void main(String[] args){

    }
}
