package lille1.dungeon.model;

/**
 * Created by damien on 30/09/15.
 */
public class Hero extends Character {

    public Inventory inventory;

    public Hero(String name) {
        super(name);
        this.setLife(50);
        this.setStrength(15);
    }

    public Hero(String name, int life, int strength) {
        super(name, life, strength);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void useWeapon(Character victim) {
        super.hit(victim);
        // prendre la premiere arme et frapper avec, si yen a pas il y a juste les degat pure
/*        victim.setLife(victim.getLife() - this.getStrength());*/
    }

    /*
    * use Potion, Boit la premiere potion de la liste si il y en a , pas de max de vie ???
    * */
}
