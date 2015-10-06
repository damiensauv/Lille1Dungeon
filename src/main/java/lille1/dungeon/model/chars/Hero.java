package lille1.dungeon.model.chars;

import lille1.dungeon.model.stuff.Inventory;

/**
 * Created by damien on 30/09/15.
 */
public class Hero extends Character {

    public Inventory inventory;

    public Hero(String name) {
        this.setLife(50);
        this.setStrength(15);
    }

    public Hero(String name, int life, int strength){}

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
    public void hit(Character victim) {

    }
}
