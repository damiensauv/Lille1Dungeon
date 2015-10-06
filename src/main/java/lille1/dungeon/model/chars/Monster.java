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
        if (vStrength >= mStrength) return;
        int strDif = mStrength - vStrength;
        int vLife = victim.getLife();
        vLife -= strDif;
        victim.setLife(vLife);
    }

    @Override
    public boolean isDead() {
        return (this.getLife() <= 0);
    }

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
