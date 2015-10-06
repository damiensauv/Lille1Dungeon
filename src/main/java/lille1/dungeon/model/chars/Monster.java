package lille1.dungeon.model.chars;

import java.lang.*;

/**
 * Created by damien on 30/09/15.
 */
public class Monster extends java.lang.Character {

    public Monster(String name) {
        this.setLife(30);
        this.setStrength(10);
    }

    public Monster(String name, int life, int strength) {

    }

    @Override
    public int getLife() {
        return 0;
    }

    @Override
    public void setLife(int life) {

    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public void setStrength(int strength) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void hit(java.lang.Character victim) {

    }
}
