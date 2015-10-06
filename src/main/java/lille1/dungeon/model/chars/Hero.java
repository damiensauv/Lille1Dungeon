package lille1.dungeon.model.chars;

import lille1.dungeon.model.stuff.Inventory;
import lille1.dungeon.model.stuff.Items;

/**
 * Created by damien on 30/09/15.
 */
public class Hero extends Character {

    public static final int HERO_DEFAULT_LIFE = 50;
    public static final int HERO_DEFAULT_STRENGTH = 15;
    public static final int HERO_BONUS_OVER_ALL_CHARS = 2;

    public Hero(String name) {
        this.name = name;
        this.life = HERO_DEFAULT_LIFE;
        this.strength = HERO_DEFAULT_STRENGTH;
        this.inventory = new Inventory();
    }

    public Hero(String name, int life, int strength) {
        this.life = life;
        this.name = name;
        this.strength = strength;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void useWeapon(java.lang.Character victim) {
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
        int mStrength = this.getStrength() * Hero.HERO_BONUS_OVER_ALL_CHARS;
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

    public void lootObject(Items loot) {
        this.inventory.add(loot);
    }
}
