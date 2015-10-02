package lille1.dungeon.model;

/**
 * Created by damien on 30/09/15.
 */
public class Monster extends Personage {
    public Monster(String name) {
        super(name);
        this.setLife(30);
        this.setStrength(10);
    }

    public Monster(String name, int life, int strength) {
        super(name, life, strength);
    }
}
