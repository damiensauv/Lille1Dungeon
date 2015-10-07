package lille1.dungeon.model.chars;

import lille1.dungeon.model.stuff.Inventory;
import lille1.dungeon.model.stuff.Items;

import java.util.Random;

/**
 * Created by damien on 30/09/15.
 */
public class Monster extends Character {

    public static final int MONSTER_DEFAULT_LIFE = 30;
    public static final int MONSTER_DEFAULT_STRENGTH = 10;

    public Monster(String name) {
        this.name = name;
        this.life = MONSTER_DEFAULT_LIFE;
        this.strength = MONSTER_DEFAULT_STRENGTH;
        this.inventory = new Inventory();
    }

    public Monster(String name, int life, int strength) {
        this.life = life;
        this.name = name;
        this.strength = strength;
        this.inventory = new Inventory();
    }

    /**
     * Monster hit the victim
     * @param victim
     */
    @Override
    public void hit(Character victim) {
        int vStrength = victim.getStrength();
        int mStrength = this.getStrength();
        if (vStrength >= mStrength) return;
        int strDif = mStrength - vStrength;
        int vLife = victim.getLife();
        vLife -= strDif;
        victim.setLife(vLife);
    }

    /**
     * Check if monster is dead
     * @return
     */
    @Override
    public boolean isDead() {
        return (this.getLife() <= 0);
    }

    /**
     * Drop Random object after dead
     * @return
     */
    public Items dropObject() {
        Random lootRand = new Random();
        switch(lootRand.nextInt(3)) {
            case 0 : return this.inventory.getFirstKey();
            case 1 : return this.inventory.getFirstPotion();
            case 2 : return this.inventory.getFirstWeapon();
        }
        return null;
    }
}
