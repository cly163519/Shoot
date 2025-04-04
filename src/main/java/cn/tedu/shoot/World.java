package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.InputStream;

public class World extends JPanel{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 700;

    //Represents the object displayed in the window
    private Sky sky = new Sky();//Sky Object
    private Hero hero = new Hero();//Hero Object
    private FlyingObject[] enemies = {//Contains Airplane,BigAirplane,Bee
            new Airplane(),
            new BigAirplane(),
            new Bee()
    };
    private Bullet[] bullets = {//Bullet Array
            new Bullet(100,200)
    };

    public void paint(Graphics g){//Draw pictures in the window
        g.drawImage(sky.getImage(),sky.x,sky.y,null);
        g.drawImage(sky.getImage(),sky.x,sky.getY1(),null);
        g.drawImage(hero.getImage(),hero.x,hero.y,null);
        for(int i=0;i<enemies.length;i++){//Traverse all enemies
            FlyingObject f = enemies[i];//Get every enemy
            g.drawImage(f.getImage(),f.x,f.y,null);//Draw enemies
        }
        for(int i=0;i<bullets.length;i++){//Traverse all bullets
            Bullet b = bullets[i];//Get every bullet
            g.drawImage(b.getImage(),b.x,b.y,null);//Draw bullet
        }
    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        World world = new World();
        frame.add(world);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);//Call paint()

        //world.action();
    }


}
