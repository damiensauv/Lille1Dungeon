package lille1.dungeon.model.chars;

import lille1.dungeon.model.stuff.Inventory;

/**
 * Created by damien on 30/09/15.
 */
public abstract class Character {

    protected String name;
    protected int life;
    protected int strength;
    protected Inventory inventory;

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return this.strength;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public abstract void hit(Character victim);

    public abstract boolean isDead();
}
