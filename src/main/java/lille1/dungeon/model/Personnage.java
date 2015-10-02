package lille1.dungeon.model;

/**
 * Created by damien on 30/09/15.
 */
public class Personnage {

    public String name = "";
    public int life = 10;
    public int strength = 5;

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Personnage(String name) {
        this.name = name;
    }

    public Personnage(String name, int life, int strength) {
        this.name = name;
        this.life = life;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    *  Le mec en parametre c celui que l'on frappe
    * */
    public void hit(Personnage victime){
        /*
        *  -- this degat pure life victime
        * */
    }

}
