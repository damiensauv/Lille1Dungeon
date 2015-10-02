package lille1.dungeon.model;

/**
 * Created by damien on 30/09/15.
 */

/*
maybe abstract
 */
public abstract class Items {

    public final static String WEAPON = "weapon";
    public final static String POTION = "potion";
    public final static String UTILITY = "utility";

    public String name = "";

    public Items(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getType();

}
