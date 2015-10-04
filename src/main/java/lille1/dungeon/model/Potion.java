package lille1.dungeon.model;

/**
 * Created by sauvalle on 01/10/15.
 */
public class Potion  extends Items{

    public int gainLife = 0;

    public Potion(String name, int gainLife) {
        super(name);
        this.gainLife = gainLife;
    }

    public int getGainLife() {
        return gainLife;
    }


    public void setGainLife(int gainLife) {
        this.gainLife = gainLife;
    }
}