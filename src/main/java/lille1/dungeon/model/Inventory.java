package lille1.dungeon.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        this.items.add(item);
    }

    public List<Items> get() {
        return null;
    }

    public void remove(Items items) {

    }

    /*
    *  method is empty ...
    *  method get Nb element
    *  method print Inventory
    * */

}
