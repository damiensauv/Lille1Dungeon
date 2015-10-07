package lille1.dungeon.model.tray;

import lille1.dungeon.exceptions.InvalidDirectionException;
import lille1.dungeon.exceptions.MonsterNotDeadException;
import lille1.dungeon.exceptions.RoomLockedException;
import lille1.dungeon.model.chars.Hero;
import lille1.dungeon.model.chars.Monster;

/**
 * Created by Thotol on 06/10/2015.
 */
public class MonsterRoom extends Room {

    private Monster monsterInside;

    public MonsterRoom(Monster badguy, String name) {
        super(name);
        this.monsterInside = badguy;
    }

    /**
     * override Room.nextRoom to throw exception if the monster is not dead
     * @param direction the direction
     * @return the next room
     * @throws MonsterNotDeadException if the monster is not dead
     */
    @Override
    public Room nextRoom(String direction) throws RoomLockedException, InvalidDirectionException {
        if(!(this.monsterInside.isDead())) throw new MonsterNotDeadException();
        return super.nextRoom(direction);
    }

    public Monster getMonster() {
        return this.monsterInside;
    }

    public String toString() {
        if(this.monsterInside!=null) return this.name + " Monster : "+this.monsterInside.getName() + " Life : "+this.monsterInside.getLife();
        return this.name;
    }

    public void processFight(Hero badassHero) {
        badassHero.hit(this.monsterInside);
        if(this.monsterInside.isDead()) {
            badassHero.lootObject(this.monsterInside.dropObject());
            this.monsterInside = null;
        }
    }
}
