package lille1.dungeon.model;

import java.util.List;
import java.util.Map;

/**
 * Created by sauvalle on 01/10/15.
 */

/* GO TRANSLATE IN INGLISH !!!!! :D
On peut utiliser pour les inventaire de la salle et des personnage
 */

public class Inventory {

    public List<Weapons> weapons;
    public List<Key> key;
    public List<Potion> potion;


    protected Map<Items.Type, Items> map;

    public Inventory() {
    /*
    a init les list .?
    * */

    }

    public void add(Items item) {
        map.put(item.getType(), item);
    }

    public List<Items> get(Items.Type type) {
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
