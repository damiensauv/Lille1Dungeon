package lille1.dungeon.model;

/**
 * Created by damien on 30/09/15.
 */

public abstract class Items {

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

    public String print(){
        return getName() + " ";
    }

}
