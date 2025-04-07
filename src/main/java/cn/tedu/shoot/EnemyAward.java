package cn.tedu.shoot;

public interface EnemyAward {
    public int FIRE = 0; //Firepower level
    public int LIFE = 1; //Current lives

    public int getAwardType();//Get the reward type
}
