package lille1.dungeon.model.stuff;

/**
 * Created by sauvalle on 01/10/15.
 */
public class Potion extends Items {

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

    @Override
    public String print() {
        return super.print() + "Potion Gain life " + Integer.toString(this.getGainLife());
    }
}
