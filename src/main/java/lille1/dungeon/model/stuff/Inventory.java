package lille1.dungeon.model.stuff;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sauvalle on 01/10/15.
 */

/**
 * Inventory of player and Rooms
 */
public class Inventory {

    /**
     * List of Items
     */
    public List<Items> items;

    /**
     * Create List
     */
    public Inventory() {
        this.items = new LinkedList<Items>();
    }

    /**
     * Add items in Inventory
     */
    public void add(Items item) {
        if(item != null) this.items.add(item);
    }

    /**
     * Print all Inventory
     */
    public void printInventory() {

        if (this.items.size() == 0) {
            System.out.println("This inventory is empty !");
        } else {
            System.out.println("Inventory : ");

            for (Items items : this.items) {
                if (items instanceof Key)
                    System.out.println(((Key) items).print());
                else if (items instanceof Weapons)
                    System.out.println(((Weapons) items).print());
                else if (items instanceof Potion)
                    System.out.println(((Potion) items).print());
                else
                    System.out.println("Bad Object");
            }

        }
    }

    /**
     * get the first Weapon
     */
    public Weapons getFirstWeapon() {
        for (Items items : this.items) {
            if (items instanceof Weapons) {
                return ((Weapons) items);
            }
        }
        System.out.println("No Weapon."); // Ici ?
        return null;
    }

    /**
     * get the first Key
     */
    public Key getFirstKey() {
        for (Items items : this.items) {
            if (items instanceof Key) {
                return ((Key) items);
            }
        }
        System.out.println("No Key."); // Ici ?
        return null;
    }

    /**
     * get the first Potion
     */
    public Potion getFirstPotion() {
        for (Items items : this.items) {
            if (items instanceof Potion) {
                return ((Potion) items);
            }
        }
        System.out.println("No Potion."); // Ici ?
        return null;
    }

    /**
     * delete items in params
     */
    public void removeItems(Items itemsRemove) {
        this.items.remove(itemsRemove);
    }

}
