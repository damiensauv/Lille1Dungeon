package lille1.dungeon.model.chars;

/**
 * Created by damien on 30/09/15.
 */
public abstract class Character {

    protected String name;
    protected int life;
    protected int strength;

    public abstract int getLife();

    public abstract void setLife(int life);

    public abstract int getStrength();

    public abstract void setStrength(int strength);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void hit(Character victim);

    public abstract boolean isDead();
}
