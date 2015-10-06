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

    public abstract int getLife();

    public abstract void setLife(int life);

    public abstract int getStrength();

    public abstract void setStrength(int strength);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void hit(Character victim);

    public abstract boolean isDead();
}
