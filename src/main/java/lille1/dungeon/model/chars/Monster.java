package lille1.dungeon.model.chars;

/**
 * Created by damien on 30/09/15.
 */
public class Monster extends Character {

    public static final int MONSTER_DEFAULT_LIFE = 30;
    public static final int MONSTER_DEFAULT_STRENGTH = 10;

    public Monster(String name) {
        this.setLife(MONSTER_DEFAULT_LIFE);
        this.setStrength(MONSTER_DEFAULT_STRENGTH);
    }

    public Monster(String name, int life, int strength) {

    }

    @Override
    public int getLife() {
        return this.life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void hit(Character victim) {
        int vStrength = victim.getStrength();
        int mStrength = this.getStrength();
        if(vStrength>=mStrength) return;
        int strDif = mStrength - vStrength;
        int vLife = victim.getLife();
        vLife -= strDif;
        victim.setLife(vLife);
    }
}
