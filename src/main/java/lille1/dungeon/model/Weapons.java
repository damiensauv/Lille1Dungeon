package lille1.dungeon.model;

/**
 * Created by sauvalle on 01/10/15.
 */
public class Weapons extends Items {

    public int damage = 0;

    public Weapons(String name) {
        super(name);
    }

    public Weapons(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (damage < 0)
            this.damage = 0;
        else
            this.damage = damage;
    }

}
