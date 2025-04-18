package cn.tedu.shoot;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class World extends JPanel{
    public static final int WIDTH = 400;//The window's width
    public static final int HEIGHT = 700;//The window's height

    public static final int START = 0;//Start up state
    public static final int RUNNING = 1;//Running state
    public static final int PAUSE = 2;//Pausing state
    public static final int GAME_OVER = 3;//Game is over
    private int state = START;//Default state

    //Represents the object displayed in the window
    private Sky sky = new Sky();//Sky Object
    private Hero hero = new Hero();//Hero Object
    private FlyingObject[] enemies = {};//Contains Airplane,BigAirplane,Bee
    private Bullet[] bullets = {};//Bullet Array

    //Generate enemies objects
    public FlyingObject nextOne(){
        Random rand = new Random();
        int type = rand.nextInt(20);//A random number between 0 and 19
        if(type<5){ //Between 0-4,return Bee object
            return new Bee();
        }else if(type<13){ //Between 5-12,return Airplane object
            return new Airplane();
        }else{ //Between 13-19, return BigAirplane
            return new BigAirplane();
        }
    }

    private int enterIndex = 0;//Enemy entry counter
    //Enemies(Airplane/BigAirplane/Bee) enter
    public void enterAction(){ //Every 10 milliseconds
        enterIndex++; // Increases every 10 milliseconds
        if(enterIndex%40==0){ //Executes every 400 milliseconds
            FlyingObject obj = nextOne();//Get enemy objects
            enemies = Arrays.copyOf(enemies,enemies.length+1);//Expanding the array
            enemies[enemies.length-1] = obj;// Adding obj to the last element of the enemy array
        }
    }

    private int shootIndex = 0;//Bullet entry counter
    //Bullets entry
    public void shootAction(){
        shootIndex++;//Increase by 1 every 10 milliseconds
        if(shootIndex%30 == 0){//Goes every 300 milliseconds
            Bullet[] bs = hero.shoot();//Get an array of bullets fired by the Hero
            bullets = Arrays.copyOf(bullets,bullets.length+bs.length);//Expanding the Bullet Array.Expand the capacity by as many elements as there are in the bs.
            System.arraycopy(bs,0,bullets,bullets.length-bs.length,bs.length);//Appending of arrays
        }
    }

    //Flying object movement
    public void stepAction(){//Every 10 milliseconds
        sky.step(); //Flying object on the move.
        for(int i=0;i<enemies.length;i++){ //Traverse all enemies
            enemies[i].step();//Enemies move.
        }
        for(int i=0;i<bullets.length;i++){ //Traverse all bullets
            bullets[i].step(); //Bullets move.
        }
    }

    //Deletion of cross-border enemies and bullets
    public void outOfBoundsAction(){
        for(int i=0;i<enemies.length;i++){ //Traverse all enemies
            if(enemies[i].isOutOfBounds() || enemies[i].isRemove()){ //Enemies are out of bounds
                enemies[i] = enemies[enemies.length-1];//Replace the out-of-bounds enemy with the last element of the enemies array.
                enemies = Arrays.copyOf(enemies,enemies.length-1);//Reduce the array's size
            }
        }
        for(int i=0;i<bullets.length;i++){ //Travers all bullets
            if(bullets[i].isOutOfBounds() || bullets[i].isRemove()){ //Bullet is out of bounds.
                bullets[i] = bullets[bullets.length-1];
                bullets = Arrays.copyOf(bullets,bullets.length-1);
            }
        }
    }

    private int score = 0;//Player's scores
    //Game collision detection and handling logic, involving interactions between multiple objects
    //Bullet collision with the enemy
    public void bulletBangAction(){ //Every 10 milliseconds
        for(int i=0;i<bullets.length;i++){ //Traverse all bullets
            Bullet b = bullets[i]; //Get every bullet
            for(int j=0;j<enemies.length;j++){//Travers all enemies
                FlyingObject f = enemies[j];//Get every enemy
                if(b.isLive() && f.isLive() && f.isHit(b)){//All Flying Objects are alive and collide
                    b.goDead();//Bullets go dead
                    f.goDead();//Flying objects go dead
                    if(f instanceof EnemyScore){//If the collided object can earn points--All classes that implement EnemyScore
                        EnemyScore es = (EnemyScore)f;// Cast the collided object to the EnemyScore interface
                        score += es.getScore();//Player get scores
                    }
                    if(f instanceof EnemyAward){//If the collided object can get rewards--All classes that implement EnemyAward
                        EnemyAward ea = (EnemyAward)f;//Cast the collided object to the EnemyAward
                        int type = ea.getAwardType();//Get AwardType
                        switch(type){ // Get different types of rewards
                            case EnemyAward.FIRE:
                                hero.addFire();
                                break;
                            case EnemyAward.LIFE:
                                hero.addLife();
                                break;
                        }
                    }
                }
            }
        }
    }

    //Hero collision with the enemy
    public void heroBangAction(){
        for(int i=0;i<enemies.length;i++){
            FlyingObject f = enemies[i];
            if(hero.isLive() && f.isLive() && f.isHit(hero)){
                f.goDead();
                hero.subtractLife();
                hero.clearFire();
            }
        }
    }

    //Check if the game is over
    public void checkGameOverAction(){
        if(hero.getLife()<=0){ //If Hero's life<=0,game is over
            state = GAME_OVER;
        }
    }

    //Start program execution
    public void action(){
        MouseAdapter m = new MouseAdapter(){
            @Override
            //Rewrite mouseMoved() method
            public void mouseMoved(MouseEvent e){
                if(state==RUNNING){// Execute only when in running state
                    int x = e.getX();//Get the x-coordinate of the mouse
                    int y = e.getY();//Get the y-coordinate of the mouse
                    hero.moveTo(x,y);//Hero's movement
                }
            }
            //Rewrite mouseClicked() method
            public void mouseClicked(MouseEvent e){
                switch(state){
                    case START:
                        state = RUNNING;
                        break;
                    case GAME_OVER:
                        score = 0;
                        sky = new Sky();
                        hero = new Hero();
                        enemies = new FlyingObject[0];
                        bullets = new Bullet[0];
                        state = START;
                        break;
                }
            }
            //Rewrite mouseExited() method
            public void mouseExited(MouseEvent e){
                if(state==RUNNING){
                    state = PAUSE;
                }
            }
            //Rewrite mouseEntered() method
            public void mouseEntered(MouseEvent e){
                if(state==PAUSE){
                    state = RUNNING;
                }
            }
        };//Mouse Listener

        this.addMouseListener(m);//Install listener
        this.addMouseMotionListener(m);//Install listener

        Timer timer = new Timer();//Timer object
        int intervel = 10;//Timed interval(In milliseconds)
        timer.schedule(new TimerTask(){
            public void run(){//What the timer does (every 10 milliseconds)
                if(state==RUNNING){// Execute only when in running state
                    enterAction();//Enemies(Airplane/BigAirplane/Bee) enter;
                    shootAction();//Bullet entry;
                    stepAction();//FlyingObject movement
                    outOfBoundsAction();//Deletion of cross-border enemies and bullets
                    bulletBangAction();//Bullet collision with the enemy
                    heroBangAction();//Hero collision with the enemy
                    checkGameOverAction();// Checks whether the game has ended based on the game rules or conditions
                }
                repaint();//Reinvoke paint
            }
        },intervel,intervel);//Schedule
    }

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
        g.drawString("SCORE:"+score,10,25);
        g.drawString("LIFE:"+hero.getLife(),10,45);

        switch(state){// Draw different pictures based on the current game state
            case START:
                g.drawImage(Images.start,0,0,null);
                break;
            case PAUSE:
                g.drawImage(Images.pause,0,0,null);
                break;
            case GAME_OVER:
                g.drawImage(Images.gameover,0,0,null);
                break;
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

        world.action();//Call action(), Start program execution
    }

}
