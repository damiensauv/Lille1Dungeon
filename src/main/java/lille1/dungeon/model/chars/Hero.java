package lille1.dungeon.model.chars;

import lille1.dungeon.model.stuff.*;

/**
 * Created by damien on 30/09/15.
 */
public class Hero extends Character {

    public static final int HERO_DEFAULT_LIFE = 50;
    public static final int HERO_DEFAULT_STRENGTH = 15;
    public static final int HERO_BONUS_OVER_ALL_CHARS = 2;

    /**
     * Default Constructor Hero
     * @param name
     */
    public Hero(String name) {
        this.name = name;
        this.life = HERO_DEFAULT_LIFE;
        this.strength = HERO_DEFAULT_STRENGTH;
        this.inventory = new Inventory();
    }

    /**
     * Constructor Hero
     * @param name of Hero
     * @param life Of Hero
     * @param strength of Hero
     */
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

    /**
     * Hit Victim
     */
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

    /**
     * Use first weapon in inventory
     * @param victim
     */
    public void useWeapon(Character victim) {
        Weapons weapons = this.getInventory().getFirstWeapon();
        if (weapons == null)
            this.hit(victim);
        else {
            int vStrength = victim.getStrength();
            int mStrength = this.getStrength() * Hero.HERO_BONUS_OVER_ALL_CHARS + weapons.getDamage();
            if (vStrength >= mStrength) return;
            int strDif = mStrength - vStrength;
            int vLife = victim.getLife();
            vLife -= strDif;
            victim.setLife(vLife);
            this.getInventory().removeItems(weapons);
        }
    }

    /**
     * Use first potion in inventory
     */
    public void usePotion() {
        Potion potion = this.getInventory().getFirstPotion();
        if (potion != null){
            this.setLife(this.getLife() + potion.getGainLife());
            this.getInventory().removeItems(potion);
        }
    }

    /**
     * Use First Key in inventory
     */
    public void useKey() {
        Key key = this.getInventory().getFirstKey();
        if (key != null){
         this.getInventory().removeItems(key);
        }
    }

    @Override
    public boolean isDead() {
        return (this.getLife() <= 0);
    }

    public void lootObject(Items loot) {
        this.inventory.add(loot);
    }
}
